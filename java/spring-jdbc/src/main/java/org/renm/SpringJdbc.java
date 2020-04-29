package org.renm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbc {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring_jdbc.xml");
    }
}
