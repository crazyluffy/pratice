package org.renm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QtzMain {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-quartz.xml");
    }
}
