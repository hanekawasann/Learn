package com.yukms.learn.tool.souche;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/13 10:03
 */
public class SoucheTraceHtmlParserTest {
    @Test
    public void test_getNewInstance() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/logTraceidResult.htm");
        SoucheTraceHtmlParser parser = SoucheTraceHtmlParser.getNewInstance(inputStream, "UTF-8");
        Assert.assertEquals("rich-man", parser.getProjectName());
        Assert.assertEquals("/orderRelevanceApi/getCustomerInfoByPhone.json", parser.getPath());
        Assert.assertEquals(34, parser.getTime());

        SoucheTraceHtmlParser.Trace trace1 = parser.getRoot();
        Assert.assertEquals("1", trace1.getVersion());
        List<SoucheTraceHtmlParser.Trace> child1 = trace1.getChild();

        SoucheTraceHtmlParser.Trace trace11 = child1.get(0);
        Assert.assertEquals("1.1", trace11.getVersion());
        List<SoucheTraceHtmlParser.Trace> child11 = trace11.getChild();
        Assert.assertEquals(1, child11.size());
        SoucheTraceHtmlParser.Trace trace111 = child11.get(0);
        Assert.assertEquals("1.1.1", trace111.getVersion());
        List<SoucheTraceHtmlParser.Trace> child111 = trace111.getChild();
        SoucheTraceHtmlParser.Trace trace1111 = child111.get(0);
        Assert.assertEquals(1, child111.size());
        Assert.assertEquals("1.1.1.1", trace1111.getVersion());
        Assert.assertEquals(0, trace1111.getChild().size());

        SoucheTraceHtmlParser.Trace trace12 = child1.get(1);
        Assert.assertEquals("1.2", trace12.getVersion());
        List<SoucheTraceHtmlParser.Trace> child12 = trace12.getChild();
        Assert.assertEquals(1, child12.size());
        SoucheTraceHtmlParser.Trace trace121 = child12.get(0);
        Assert.assertEquals("1.2.1", trace121.getVersion());
        List<SoucheTraceHtmlParser.Trace> child121 = trace121.getChild();
        Assert.assertEquals(1, child121.size());
        SoucheTraceHtmlParser.Trace trace1211 = child121.get(0);
        Assert.assertEquals("1.2.1.1", trace1211.getVersion());
        List<SoucheTraceHtmlParser.Trace> child1211 = trace1211.getChild();
        Assert.assertEquals(3, child1211.size());
        SoucheTraceHtmlParser.Trace trace12111 = child1211.get(0);
        Assert.assertEquals("1.2.1.1.1", trace12111.getVersion());
        Assert.assertEquals(0, trace12111.getChild().size());
        SoucheTraceHtmlParser.Trace trace12112 = child1211.get(1);
        Assert.assertEquals("1.2.1.1.2", trace12112.getVersion());
        Assert.assertEquals(0, trace12112.getChild().size());
        SoucheTraceHtmlParser.Trace trace12113 = child1211.get(2);
        Assert.assertEquals("1.2.1.1.3", trace12113.getVersion());
        Assert.assertEquals(0, trace12113.getChild().size());

        SoucheTraceHtmlParser.Trace trace13 = child1.get(2);
        Assert.assertEquals("1.3", trace13.getVersion());
        List<SoucheTraceHtmlParser.Trace> child13 = trace13.getChild();
        Assert.assertEquals(1, child13.size());
        SoucheTraceHtmlParser.Trace trace131 = child13.get(0);
        Assert.assertEquals("1.3.1", trace131.getVersion());
        List<SoucheTraceHtmlParser.Trace> child131 = trace131.getChild();
        Assert.assertEquals(1, child131.size());
        SoucheTraceHtmlParser.Trace trace1311 = child131.get(0);
        Assert.assertEquals("1.3.1.1", trace1311.getVersion());
        Assert.assertEquals(0, trace1311.getChild().size());
    }

    @Test
    public void test_parseTrace() {
        Element element = new Element("tr");
        element.append(
            "<td><span class=\"c_stretch c_f_left c_none_elemt\"> </span><span class=\"c_stretch c_f_left c_none_elemt\"> </span><span class=\"c_stretch j_stretch  c_f_left\">-</span><span class=\"c_f_left\"><span id=\"1.2.1\">1.2.1</span></span></td><td class=\"j_pt\" alt=\"danube-authorization\" title=\"danube-authorization\"><span>danube-authorization</span></td><td class=\"j_pt\" alt=\"傅杭波\" title=\"傅杭波\"><span>傅杭波</span></td><td alt=\"dubbo-service\" title=\"dubbo-service\"><span>dubbo-service</span></td><td><span>2020-03-13 08:14:11.710</span></td><td class=\"j_cost\"><span>2</span></td><td class=\"j_waterfall\"><div class=\"progress\"><span class=\"span_front\" style=\"width: 26.470588235294116%;\" alt=\"前面耗时占比:26.470588235294116%\" title=\"前面耗时占比:26.470588235294116%\"></span><span class=\"green\" style=\"width: 5.882352941176471%;\" alt=\"耗时占比:5.882352941176471%\" title=\"耗时占比:5.882352941176471%\"></span></div></td><td><span><div class=\"icoFontlist\" title=\"com.souche.danube.authorization.api.UserService.get(class\" java.lang.string)=\"\">com.souche.danube.authorization.api.UserService.get(class java.lang.String)</div></span></td><td><span>172.16.35.140</span></td><td><span>172.16.32.102:20880</span></td><td><span></span></td><td><span>souche</span></td><td><span></span></td><td><span>prod</span></td><td class=\"c_text_center\"><span><a target=\"_blank\" href=\"/index.html#/detail?rid=1584058451697_xao7-1.2.1&amp;&amp;from=TRACETREE&amp;&amp;alarmId=undefined\">详情</a>&nbsp;&nbsp;<a target=\"_blank\" href=\"http://logplatform.souche-inc.com/#/apps?appName=danube-authorization&amp;tid=1584058451697_xao7&amp;&amp;alarmId=undefined\">业务日志</a></span></td>");
        SoucheTraceHtmlParser.Trace trace = SoucheTraceHtmlParser.parseTrace(element);
        Assert.assertEquals("1.2.1", trace.getVersion());
        Assert.assertEquals("danube-authorization", trace.getProjectName());
        Assert.assertEquals("dubbo-service", trace.getType());
        Assert.assertEquals(2, trace.getTime());
        Assert.assertEquals(5.882352941176471D, trace.getTimePercentage(), 0);
        Assert.assertEquals("com.souche.danube.authorization.api.UserService.get(class java.lang.String)",
            trace.getPath());
        Assert.assertEquals(0, trace.getChild().size());
    }

    @Test
    public void test_parseStyle() {
        Map<String, String> style = SoucheTraceHtmlParser.parseStyle("width: 26.470588235294116%;height: 10px");
        Assert.assertEquals("26.470588235294116%", style.get("width"));
        Assert.assertEquals("10px", style.get("height"));
    }

    @Test
    public void test_Trace() {
        SoucheTraceHtmlParser.Trace trace1 = new SoucheTraceHtmlParser.Trace("1.1", "name", "type", 0L, 0L, "path");
        SoucheTraceHtmlParser.Trace trace2 = new SoucheTraceHtmlParser.Trace("1.1.1", "name", "type", 0L, 0L, "path");
        SoucheTraceHtmlParser.Trace trace3 = new SoucheTraceHtmlParser.Trace("1.1.1.1", "name", "type", 0L, 0L, "path");
        SoucheTraceHtmlParser.Trace trace4 = new SoucheTraceHtmlParser.Trace("1.1.1.2", "name", "type", 0L, 0L, "path");
        SoucheTraceHtmlParser.Trace trace5 = new SoucheTraceHtmlParser.Trace("1.1.2.1", "name", "type", 0L, 0L, "path");
        Assert.assertTrue(trace2.isChild(trace1));
        Assert.assertTrue(trace1.isParent(trace2));
        Assert.assertTrue(trace3.isSibling(trace4));
        Assert.assertFalse(trace4.isSibling(trace5));
        Assert.assertTrue(trace4.isChildBranch(trace1));
    }
}