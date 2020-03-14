package com.yukms.learn.tool.souche;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/13 9:09
 */
public class SoucheTraceHtmlParser {
    private static final String VERSION_SPLIT = ".";
    private static final String STYLE_ENTRY_SPILT = ";";
    private static final String STYLE_KEY_VALUE_SPILT = ":";
    @Getter
    private String projectName;
    @Getter
    private String path;
    @Getter
    private long time;
    @Getter
    private Trace root;
    private final InputStream inputStream;
    private final String charsetName;
    private final Document document;

    public static SoucheTraceHtmlParser getNewInstance(File file, String charsetName) throws IOException {
        return new SoucheTraceHtmlParser(new FileInputStream(file), charsetName);
    }

    public static SoucheTraceHtmlParser getNewInstance(InputStream inputStream, String charsetName) throws IOException {
        return new SoucheTraceHtmlParser(inputStream, charsetName);
    }

    private SoucheTraceHtmlParser(InputStream inputStream, String charsetName) throws IOException {
        requireNonNull(inputStream);
        this.inputStream = inputStream;
        this.charsetName = charsetName;
        this.document = Jsoup.parse(inputStream, charsetName, StringUtils.EMPTY);
        init();
    }

    private void init() {
        Elements traceTrs = document.select("#root .hhh-table-scroll .hhh-table-body .hhh-table-tbody>tr");
        initBaseAttr(traceTrs);
        initTraces(traceTrs);
    }

    private void initBaseAttr(Elements traceTrs) {
        Trace trace = parseTrace(traceTrs.first());
        projectName = trace.getProjectName();
        path = trace.getPath();
        time = trace.getTime();
    }

    private void initTraces(Elements traceTrs) {
        Trace last = null;
        Trace parent = null;
        for (Element traceTr : traceTrs) {
            Trace trace = parseTrace(traceTr);
            if (isNull(root)) {
                root = trace;
            } else {
                if (!isNull(last) && !last.isSibling(trace)) {
                    parent = findParent(root, trace);
                }
                parent.addChildTrace(trace);
            }
            last = trace;
        }
    }

    private Trace findParent(Trace root, Trace o) {
        if (root.isParent(o)) {
            return root;
        }
        List<Trace> child = root.getChild();
        for (Trace trace : child) {
            if (o.isChildBranch(trace)) {
                return findParent(trace, o);
            }
        }
        throw new IllegalStateException();
    }


    static Trace parseTrace(Element element) {
        Elements tds = element.select(">td");

        String version = tds.get(0).selectFirst(">span:last-of-type>span").text();
        String projectName = tds.get(1).attr("title");
        String type = tds.get(3).selectFirst(">span").text();
        long time = Long.parseLong(tds.get(5).selectFirst(">span").text());
        double timePercentage = Double.parseDouble(
            parseStyle(tds.get(6).selectFirst(">.progress>span:last-of-type")).get("width")
                .replace("%", StringUtils.EMPTY));
        String path = tds.get(7).selectFirst(".icoFontlist").text();
        return new Trace(version, projectName, type, time, timePercentage, path);
    }

    private static Map<String, String> parseStyle(Element element) {
        String styleStr = element.attr("style");
        if (StringUtils.isBlank(styleStr)) {
            return new HashMap<>();
        }
        return parseStyle(styleStr);
    }

    static Map<String, String> parseStyle(String styleStr) {
        Map<String, String> map = new HashMap<>();
        String[] styleElements = styleStr.split(STYLE_ENTRY_SPILT);
        for (String styleElement : styleElements) {
            String[] entry = styleElement.split(STYLE_KEY_VALUE_SPILT);
            String key = entry[0].trim();
            String value = entry[1].trim();
            map.put(key, value);
        }
        return map;
    }

    @Getter
    @ToString
    static class Trace {
        private final String version;
        private final String projectName;
        private final String type;
        private final long time;
        private final double timePercentage;
        private final String path;
        private final List<Trace> child = new ArrayList<>();

        public Trace(String version, String projectName, String type, long time, double timePercentage, String path) {
            if (StringUtils.isAnyBlank(version, projectName, type, path)) {
                throw new IllegalArgumentException();
            }
            this.version = version;
            this.projectName = projectName;
            this.type = type;
            this.time = time;
            this.timePercentage = timePercentage;
            this.path = path;
        }

        public boolean addChildTrace(Trace trace) {
            return child.add(trace);
        }

        public boolean isChild(Trace o) {
            return getParentVersion().equals(o.version);
        }

        public boolean isChildBranch(Trace o) {
            return version.startsWith(o.version + VERSION_SPLIT);
        }

        public boolean isParent(Trace o) {
            return version.equals(o.getParentVersion());
        }

        public boolean isSibling(Trace o) {
            return getParentVersion().equals(o.getParentVersion());
        }

        private String getParentVersion() {
            int i = version.lastIndexOf(VERSION_SPLIT);
            return i == -1 ? StringUtils.EMPTY : version.substring(0, i);
        }
    }
}
