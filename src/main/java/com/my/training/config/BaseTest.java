package com.my.training.config;

import com.my.training.properties.MongoDbProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {AmazonSQSConfig.class}, initializers = ConfigFileApplicationContextInitializer.class)
@EnableConfigurationProperties(value = {MongoDbProperties.class})
public class BaseTest extends AbstractTestNGSpringContextTests {
}
