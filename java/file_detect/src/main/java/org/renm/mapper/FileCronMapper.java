package org.renm.mapper;

import org.renm.pojo.FileCron;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileCronMapper {
//    @Select("select * from file_cron")
    List<FileCron> selAll();
}
