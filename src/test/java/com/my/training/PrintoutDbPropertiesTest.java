package com.my.training;

import com.my.training.config.BaseTest;
import com.my.training.properties.MongoDbProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class PrintoutDbPropertiesTest extends BaseTest {

    @Autowired
    private MongoDbProperties mongoDbProperties;

    @Test
    public void test() {
        System.out.println(mongoDbProperties.getName());
    }
}
