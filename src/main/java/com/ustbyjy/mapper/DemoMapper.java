package com.ustbyjy.mapper;

import com.ustbyjy.domain.Demo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from demo where name = #{name}")
    List<Demo> likeName(String name);

    @Select("select * from demo where id = #{id}")
    Demo getById(long id);

    @Select("select name from Demo where id = #{id}")
    String getNameById(long id);
}
