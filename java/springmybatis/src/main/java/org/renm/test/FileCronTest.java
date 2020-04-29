package org.renm.test;

import org.renm.mybatis.mapper.TaskMapper;
import org.renm.mybatis.pojo.DetectTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FileCronTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName: beanDefinitionNames
             ) {
            System.out.println(beanName);
        }
        TaskMapper taskMapper = ac.getBean("taskMapper", TaskMapper.class);
        List<DetectTask> detectTasks = taskMapper.selAll();
        for (DetectTask dt: detectTasks) {
            System.out.println(dt);
        }
    }
}
