package com.renm.cron;

import com.renm.mapper.FileCronMapper;
import com.renm.pojo.FileCron;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CronCreate {
    @Autowired
    private FileCronMapper fileCronMapper;
    @Autowired
    private FileCheck fileChecker;
    @Autowired
    private FileCheckCron fileCheckCroner;

    public void init(){
        //获取list
        List<FileCron> fileCrons = fileCronMapper.selAll();
        add(fileCrons);
    }

    public void add(List<FileCron> fileCronList){
//        Stream<FileCron> stream = fileCronList.stream();
//        fileCronList.forEach(this::addFileCheckTask);
        createFileCheck(fileCronList);
        createFileCheckCron(fileCronList);
    }

    private void createFileCheck(List<FileCron> fileCronList) {
        fileChecker.addFileCheckTask(fileCronList);
    }

    private void createFileCheckCron(List<FileCron> fileCronList) {
        fileCheckCroner.add(fileCronList);
    }

    public void add(FileCron fileCron){
        createFileCheck(fileCron);
        createFileCheckCron(fileCron);
    }

    /*
    *  创建file check 线程， 检测到结果，则记录结果集，并上报到达
    * */
    private void createFileCheck(FileCron fileCron) {
        fileChecker.addFileCheckTask(fileCron);
    }

    /*
    *  添加cron job 定时检查结果集，若不存在，则上报报警
    * */
    private void createFileCheckCron(FileCron fileCron) {
        fileCheckCroner.add(fileCron);
    }
}
