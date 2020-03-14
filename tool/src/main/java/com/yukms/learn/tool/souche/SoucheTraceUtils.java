package com.yukms.learn.tool.souche;

import static java.util.Objects.isNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/14 14:16
 */
@Slf4j
public final class SoucheTraceUtils {
    private static final String PATH_SPILT = ",";
    private static final String METHOD_SPILT = "\\.";
    private static final String PROP_FILE_PATH = "/souchetrace.properties";
    private static final Properties PROP = new Properties();

    static {
        InputStream propIn = SoucheTraceUtils.class.getResourceAsStream(PROP_FILE_PATH);
        Objects.requireNonNull(propIn);
        try {
            PROP.load(propIn);
        } catch (IOException e) {
            log.error("配置加载失败", e);
        }
    }

    public static void printQueryConfig(File file) throws IOException {
        Objects.requireNonNull(file);
        printQueryConfig(new FileInputStream(file));
    }

    public static void printQueryConfig(InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream);
        SoucheTraceHtmlParser parser = SoucheTraceHtmlParser.getNewInstance(inputStream, "UTF-8");
        SoucheTraceHtmlParser.Trace root = parser.getRoot();
        QueryConfig queryConfig = getQueryConfig(parser);
        queryConfig.setProjects(getProjects(root));
        calculateQueryConfig(queryConfig);
        printQueryConfig(queryConfig);
    }

    private static void printQueryConfig(QueryConfig queryConfig) {
        System.out.println(StringUtils.join(
            new String[] { queryConfig.getProjectName(), queryConfig.getPath(), String.valueOf(queryConfig.getTime()),
                String.valueOf(queryConfig.getQueryConfigTime()),
                String.valueOf(queryConfig.getQueryConfigTimePercentage()) }, "\t"));
        System.out.println("===================");

        for (Project project : queryConfig.getProjects()) {
            System.out.println(StringUtils.join(new String[] { project.getName(), String.valueOf(project.getNumber()),
                String.valueOf(project.getTime()), String.valueOf(project.getTimePercentage()) }, "\t"));

            List<Interface> interfaces = project.getInterfaces();
            if (CollectionUtils.isNotEmpty(interfaces)) {
                System.out.println();
            }
            int interfaceIndex = 0;
            for (Interface anInterface : interfaces) {
                System.out.println(StringUtils.join(
                    new String[] { String.valueOf(++interfaceIndex), anInterface.getName(),
                        String.valueOf(anInterface.getNumber()), String.valueOf(anInterface.getTime()),
                        String.valueOf(anInterface.getTimePercentage()) }, "\t"));
            }
            System.out.println("===================");
        }
    }

    private static void calculateQueryConfig(QueryConfig queryConfig) {
        long totalTime = queryConfig.getTime();
        long queryConfigTime = 0;
        List<Project> projects = queryConfig.getProjects();
        for (Project project : projects) {
            int projectNumber = 0;
            long projectTime = 0;
            List<Interface> interfaces = project.getInterfaces();
            interfaces.sort(Comparator.comparingInt(Interface::getNumber));
            Collections.reverse(interfaces);
            for (Interface anInterface : interfaces) {
                projectNumber += anInterface.getNumber();
                long anInterfaceTime = anInterface.getTime();
                projectTime += anInterfaceTime;
                anInterface.setTimePercentage(1D * anInterfaceTime / totalTime);
            }
            project.setNumber(projectNumber);
            project.setTime(projectTime);
            project.setTimePercentage(1D * projectTime / totalTime);
            queryConfigTime += projectTime;
        }
        queryConfig.setQueryConfigTime(queryConfigTime);
        queryConfig.setQueryConfigTimePercentage(1D * queryConfigTime / totalTime);
    }

    private static QueryConfig getQueryConfig(SoucheTraceHtmlParser parser) {
        QueryConfig queryConfig = new QueryConfig();
        queryConfig.setProjectName(parser.getProjectName());
        queryConfig.setPath(parser.getPath());
        queryConfig.setTime(parser.getTime());
        return queryConfig;
    }

    private static List<Project> getProjects(SoucheTraceHtmlParser.Trace root) {
        List<Project> projects = initProjectMap();
        List<SoucheTraceHtmlParser.Trace> traces = root.getChild();
        setTraces(projects, traces);
        return projects;
    }

    private static void setTraces(List<Project> projects, List<SoucheTraceHtmlParser.Trace> traces) {
        if (CollectionUtils.isEmpty(traces)) {
            return;
        }
        for (SoucheTraceHtmlParser.Trace trace : traces) {
            Project project = getProjectIfPresent(projects, trace);
            if (isNull(project)) {
                setTraces(projects, trace.getChild());
                continue;
            }
            setTrace(project, trace);
        }
    }

    private static void setTrace(Project project, SoucheTraceHtmlParser.Trace trace) {
        // 取下级的第一个，为了不计算传输时间
        List<Interface> interfaces = project.getInterfaces();
        String name = getName(project, trace);
        for (Interface anInterface : interfaces) {
            if (anInterface.getName().equals(name)) {
                anInterface.setNumber(anInterface.getNumber() + 1);
                anInterface.setTime(anInterface.getTime() + trace.getTime());
                return;
            }
        }
        Interface anInterface = new Interface();
        anInterface.setName(name);
        anInterface.setNumber(1);
        anInterface.setTime(trace.getTime());
        project.getInterfaces().add(anInterface);
    }

    private static String getName(Project project, SoucheTraceHtmlParser.Trace trace) {
        String name = trace.getPath();
        for (String path : project.getPaths()) {
            name = name.replaceAll(path + METHOD_SPILT, StringUtils.EMPTY);
        }
        return name;
    }

    private static Project getProjectIfPresent(List<Project> projects, SoucheTraceHtmlParser.Trace trace) {
        for (Project project : projects) {
            if (project.getName().equals(trace.getProjectName())) {
                for (String path : project.getPaths()) {
                    if (trace.getPath().startsWith(path)) {
                        return project;
                    }
                }
            }
        }
        return null;
    }

    private static List<Project> initProjectMap() {
        List<Project> projects = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : PROP.entrySet()) {
            Project project = new Project();
            String key = (String) entry.getKey();
            project.setName(key);
            String value = (String) entry.getValue();
            project.setPaths(getPath(value));
            projects.add(project);
        }
        return projects;
    }

    private static List<String> getPath(String value) {
        return Arrays.stream(value.split(PATH_SPILT)).map(String::trim).collect(Collectors.toList());
    }

    @Data
    private static class QueryConfig {
        private String projectName;
        private String path;
        private long time;
        private long queryConfigTime;
        private double queryConfigTimePercentage;
        private List<Project> projects = new ArrayList<>();
    }

    @Data
    private static class Project {
        private String name;
        private List<String> paths = new ArrayList<>();
        private int number;
        private long time;
        private double timePercentage;
        private List<Interface> interfaces = new ArrayList<>();
    }

    @Data
    private static class Interface {
        private String name;
        private int number;
        private long time;
        private double timePercentage;
    }

    private SoucheTraceUtils() { }
}
