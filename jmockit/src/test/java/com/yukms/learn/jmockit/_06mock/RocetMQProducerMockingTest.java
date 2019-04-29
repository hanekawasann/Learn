package com.yukms.learn.jmockit._06mock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import mockit.Mock;
import mockit.MockUp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author yukms 763803382@qq.com 2019/4/29 17:09
 */
public class RocetMQProducerMockingTest {
    @BeforeClass
    public static void mockRocketMQ() {
        new RocketMQProducerMockUp();
    }

    @Test
    public void testSendRocketMQMessage() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("test_producer");
        producer.setNamesrvAddr("192.168.0.2:9876;192.168.0.3:9876");
        producer.start();
        for (int i = 0; i < 20; i++) {
            Message msg = new Message("testtopic", "TagA", ("Hello " + i).getBytes());
            SendResult result = producer.send(msg);
            Assert.isTrue(result.getSendStatus() == SendStatus.SEND_OK);
            Assert.isTrue(result.getMsgId() != null);
        }
        producer.shutdown();
    }

    private static class RocketMQProducerMockUp extends MockUp<DefaultMQProducer> {
        @Mock
        void init() throws MQClientException { }

        @Mock
        void start() throws MQClientException { }

        @Mock
        void shutdown() { }

        @Mock
        List<MessageQueue> fetchPublishMessageQueues(final String topic) throws MQClientException {
            List<MessageQueue> queues = new ArrayList<>();
            MessageQueue q = new MessageQueue();
            q.setBrokerName("testbrokername");
            q.setQueueId(1);
            q.setTopic("testtopic");
            queues.add(q);
            return queues;
        }

        @Mock
        SendResult send(final Message msg)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        SendResult send(final Message msg, final long timeout)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        void send(final Message msg, final SendCallback sendCallback)
            throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void send(final Message msg, final SendCallback sendCallback, final long timeout)
            throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void sendOneway(final Message msg) throws MQClientException, RemotingException, InterruptedException {

        }

        @Mock
        SendResult send(final Message msg, final MessageQueue mq)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        SendResult send(final Message msg, final MessageQueue mq, final long timeout)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        void send(final Message msg, final MessageQueue mq, final SendCallback sendCallback)
            throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void send(final Message msg, final MessageQueue mq, final SendCallback sendCallback, long timeout)
            throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void sendOneway(final Message msg, final MessageQueue mq)
            throws MQClientException, RemotingException, InterruptedException {

        }

        @Mock
        SendResult send(final Message msg, final MessageQueueSelector selector, final Object arg)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        SendResult send(final Message msg, final MessageQueueSelector selector, final Object arg, final long timeout)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
            return newSuccessSendResult();
        }

        @Mock
        void send(final Message msg, final MessageQueueSelector selector, final Object arg,
            final SendCallback sendCallback) throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void send(final Message msg, final MessageQueueSelector selector, final Object arg,
            final SendCallback sendCallback, final long timeout)
            throws MQClientException, RemotingException, InterruptedException {
            sendCallback.onSuccess(this.newSuccessSendResult());
        }

        @Mock
        void sendOneway(final Message msg, final MessageQueueSelector selector, final Object arg)
            throws MQClientException, RemotingException, InterruptedException {

        }

        @Mock
        TransactionSendResult sendMessageInTransaction(final Message msg, final LocalTransactionExecuter tranExecuter,
            final Object arg) throws MQClientException {
            return newTransactionSendResult();
        }

        private TransactionSendResult newTransactionSendResult() {
            TransactionSendResult success = new TransactionSendResult();
            success.setSendStatus(SendStatus.SEND_OK);
            success.setMsgId(UUID.randomUUID().toString());
            MessageQueue q = new MessageQueue();
            q.setBrokerName("testbrokername");
            q.setQueueId(1);
            q.setTopic("testtopic");
            success.setMessageQueue(q);
            success.setLocalTransactionState(LocalTransactionState.COMMIT_MESSAGE);
            return success;
        }

        private SendResult newSuccessSendResult() {
            SendResult success = new SendResult();
            success.setSendStatus(SendStatus.SEND_OK);
            success.setMsgId(UUID.randomUUID().toString());
            MessageQueue q = new MessageQueue();
            q.setBrokerName("testbrokername");
            q.setQueueId(1);
            q.setTopic("testtopic");
            success.setMessageQueue(q);
            return success;
        }
    }
}
