package com.my.training.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.aws.queue")
public class AmazonSqsQueueProperties {

    private String defaultQueue;
    private String queueUrl;
    private String queueUrlBase;

    public String getDefaultQueue() {
        return defaultQueue;
    }

    public void setDefaultQueue(String defaultQueue) {
        this.defaultQueue = defaultQueue;
    }

    public String getQueueUrl() {
        return queueUrl;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    public String getQueueUrlBase() {
        return queueUrlBase;
    }

    public void setQueueUrlBase(String queueUrlBase) {
        this.queueUrlBase = queueUrlBase;
    }

}
