package com.my.training;

import com.my.training.config.BaseTest;
import com.my.training.services.amazon.AmazonSQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class SqsTest extends BaseTest{

    @Autowired
    private AmazonSQSService amazonSQSService;

    @Test
    public void test() {
        amazonSQSService.sendMessageToQueue("Very first program message", null);
    }

}
