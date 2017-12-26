package com.yk.dao;

import com.yk.pojo.DepartMent;
import com.yk.pojo.DepartMentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartMentMapper {
    long countByExample(DepartMentExample example);

    int deleteByExample(DepartMentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartMent record);

    int insertSelective(DepartMent record);

    List<DepartMent> selectByExample(DepartMentExample example);

    DepartMent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    int updateByExample(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    int updateByPrimaryKeySelective(DepartMent record);

    int updateByPrimaryKey(DepartMent record);
}