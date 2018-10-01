package com.my.training.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.my.training.properties.AmazonSqsCredentials;
import com.my.training.properties.AmazonSqsQueueProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({ AmazonSqsCredentials.class, AmazonSqsQueueProperties.class })
@ComponentScan(basePackages = "com.my.training.services.amazon")
public class AmazonSQSConfig {

    @Autowired
    private AmazonSqsCredentials sqsCredentials;

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(sqsCredentials.getAccessKey(), sqsCredentials.getSecretKey())
        );
        return credentialsProvider;
    }

    @Bean
    public AmazonSQS amazonSqsProvider() {
        return AmazonSQSClientBuilder.standard()
                .withCredentials(awsCredentialsProvider())
                .withRegion("us-east-2")
                .build();
    }

}
