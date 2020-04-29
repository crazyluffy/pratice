package org.renm.mapper;

import org.renm.pojo.FileCheckResult;

import java.util.List;

public interface FileCheckResultMapper {
    int insert(FileCheckResult result);
    List<FileCheckResult> selAll();
}
