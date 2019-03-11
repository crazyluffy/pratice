package com.renm.mapper;

import com.renm.pojo.FileCron;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileCronMapper {
//    @Select("select * from file_cron")
    List<FileCron> selAll();
}
