package com.hodor.test;

import com.hodor.controller.OrderController;
import org.junit.Test;
import org.springframework.container.ClassPathXmlApplicationContext;

/**
 * @author ：hodor007
 * @date ：Created in 2021/2/7
 * @description ：
 * @version: 1.0
 */
public class TestSpringIoc {
    //测试获取包扫描路径
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderController orderController = (OrderController) context.getBean(OrderController.class);
        orderController.findOrders();
//        orderController.addOrder();
    }
}
