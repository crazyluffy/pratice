package org.renm.test;

import org.renm.mapper.FileCheckResultMapper;
import org.renm.pojo.FCResult;
import org.renm.pojo.FileCheckResult;
import org.renm.pojo.FileCron;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class FileCheckResultMapperTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FileCron fileCron = new FileCron();
        fileCron.setId(1);
        FileCheckResult fileCheckResult = new FileCheckResult();
        fileCheckResult.setRes(FCResult.Y);
        fileCheckResult.setFileCron(fileCron);
        fileCheckResult.setTime(new Date());
        FileCheckResultMapper fileCheckResultMapper = ac.getBean(FileCheckResultMapper.class);
        fileCheckResultMapper.insert(fileCheckResult);
        List<FileCheckResult> fileCheckResults = fileCheckResultMapper.selAll();
        for (FileCheckResult fileCheckResult1: fileCheckResults) {
            System.out.println(fileCheckResult1);
        }
    }
}
