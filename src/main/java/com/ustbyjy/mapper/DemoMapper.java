package com.ustbyjy.mapper;

import com.ustbyjy.domain.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from demo where name like \"%\"#{name}\"%\"")
    List<Demo> likeName(String name);

    @Select("select * from demo where id = #{id}")
    Demo getById(long id);

    @Select("select name from demo where id = #{id}")
    String getNameById(long id);

    @Insert("insert into demo(name) values(#{name})")
    int insert(String name);
}
