package com.my.training.services.amazon;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.my.training.properties.AmazonSqsQueueProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Reporter;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class AmazonSQSService {

    @Autowired
    private AmazonSQS amazonSqs;

    @Autowired
    private AmazonSqsQueueProperties amazonSqsQueueProperties;

    private String queueUrl;

    @PostConstruct
    public void init() {
        if (amazonSqsQueueProperties != null) {
            queueUrl = amazonSqsQueueProperties.getQueueUrl();
        }
    }

    public synchronized void sendMessageToQueue(String message, Map<String, MessageAttributeValue> attributes) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest
                .withMessageBody(message)
                .withQueueUrl(queueUrl)
                .withMessageAttributes(attributes);
        amazonSqs.sendMessage(sendMessageRequest);
    }

    public Message receiveMessageFromQueue() {
        return null;
    }

    public void setAmazonSqs(AmazonSQS amazonSqs) {
        this.amazonSqs = amazonSqs;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

}
