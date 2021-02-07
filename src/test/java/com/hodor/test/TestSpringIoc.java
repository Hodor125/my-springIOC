package com.hodor.test;

import org.junit.Test;
import org.springframework.container.ClassPathXmlApplicationContext;

/**
 * @author ：hodor007
 * @date ：Created in 2021/2/7
 * @description ：
 * @version: 1.0
 */
public class TestSpringIoc {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
