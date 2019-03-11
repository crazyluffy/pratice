package com.renm.test;

import com.renm.mapper.FileCronMapper;
import com.renm.pojo.FileCron;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FielCronMapperTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }
        FileCronMapper fileCronMapper = ac.getBean(FileCronMapper.class);
        List<FileCron> fileCrons = fileCronMapper.selAll();
        for (FileCron fc: fileCrons) {
            System.out.println(fc);
        }
    }
}
