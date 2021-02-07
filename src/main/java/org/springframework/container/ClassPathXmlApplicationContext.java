package org.springframework.container;

import org.springframework.xml.SpringConfigPaser;

/**
 * @author ：hodor007
 * @date ：Created in 2021/2/7
 * @description ：
 * @version: 1.0
 */
public class ClassPathXmlApplicationContext {
    //传入配置文件名
    private String springConfig;

    public ClassPathXmlApplicationContext(String springConfig) {
        this.springConfig = springConfig;
        init();
    }

    private void init() {
        String basePackage = SpringConfigPaser.getBasePackage(springConfig);
        System.out.println(basePackage);
    }
}
