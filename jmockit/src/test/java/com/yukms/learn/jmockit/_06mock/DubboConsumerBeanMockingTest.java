package com.yukms.learn.jmockit._06mock;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.yukms.learn.jmockit.MailService;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yukms 763803382@qq.com 2019/4/29 17:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "" })
public class DubboConsumerBeanMockingTest {
    // 这里要@BeforeClass,因为要抢在spring加载dubbo前，对dubbo的消费工厂bean
    // ReferenceBean进行mock，不然dubbo可能因为连上不zk或无法找到
    // 服务的提供者等原因而无法初始化的，进而，单元测试运行不下去
    @BeforeClass
    public static void mockDubbo() {
        // 你准备mock哪个消费bean
        // 比如要对dubbo-consumber.xml里配置的cn.jmockit.demos.MailService这个消费bean进行mock
        Map<String, Object> mockMap = new HashMap<String, Object>();
        //mockMap.put("cn.jmockit.demos.MailService", new MockUp(MailService.class) {
        //    @Mock
        //    public boolean sendMail(long userId, String content) {
        //        return true;
        //    }
        //}.getMockInstance());
        // 如果要Mock其它的消费bean，自行添加,mockMap.put.....如上
        new DubboConsumerBeanMockUp(mockMap);
    }

    // 现在你使用的dubbo消费bean就是本地mock过的了，并不是指向远程dubbo服务的bean了
    @Resource
    MailService mailService;

    @Test
    public void testSendMail() {
        long userId = 123456;
        String content = "test mail content";
        Assert.assertFalse(mailService.sendMail(userId, content));
    }

    private static class DubboConsumerBeanMockUp extends MockUp<ReferenceBean> {
        private Map<String, Object> mockMap;

        public DubboConsumerBeanMockUp() { }

        public DubboConsumerBeanMockUp(Map<String, Object> mockMap) {
            this.mockMap = mockMap;
        }

        @SuppressWarnings("unchecked")
        @Mock
        public Object getObject(Invocation inv) throws Exception {
            ReferenceBean referenceBean = inv.getInvokedInstance();
            String interfaceName = referenceBean.getInterface();
            Object mock = mockMap.get(interfaceName);
            if (mock != null) {
                return mock;
            }
            //return (new MockUp(Class.forName(interfaceName)) {
            //}).getMockInstance();
            return null;
        }
    }
}
