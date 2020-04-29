package org.renm.mybatis.mapper;

import org.renm.mybatis.pojo.DetectTask;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskMapper {
    @Select("select * from file_cron")
    List<DetectTask> selAll();
}
