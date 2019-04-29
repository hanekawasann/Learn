package com.yukms.learn.jmockit._07advanced;

import java.util.HashMap;
import java.util.Map;

import com.yukms.learn.jmockit.ISayHello;
import com.yukms.learn.jmockit.SayHello;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:38
 */
public class MethodCostPerformanceTest {
    @Test
    public void testSayHelloCostPerformance() {
        // 把方法的调用时间记录到costMap中。key是方法名称，value是平均调用时间
        Map<String, Long> costMap = new HashMap<>();
        new MockUp<SayHello>() {
            @Mock
            public Object $advice(Invocation invocation) {
                long a = System.currentTimeMillis();
                Object result = invocation.proceed();
                long cost = System.currentTimeMillis() - a;
                String methodName = invocation.getInvokedMember().getName();
                costMap.merge(methodName, cost, (a1, b) -> (a1 + b) / 2);
                return result;
            }
        };
        SayHello sayHello = new SayHello();
        sayHello.sayHello("david", ISayHello.MALE);
        sayHello.sayHello("lucy", ISayHello.FEMALE);
        for (String methodName : costMap.keySet()) {
            Long aLong = costMap.get(methodName);
            System.out.println(methodName + ":" + aLong);
            Assert.isTrue(aLong < 20);
        }
    }
}
