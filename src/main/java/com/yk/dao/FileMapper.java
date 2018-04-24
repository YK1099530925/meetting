package com.yk.dao;

import com.yk.pojo.File;
import com.yk.pojo.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);
}