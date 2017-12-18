package com.ustbyjy.mapper;

import com.ustbyjy.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/7
 * Time: 14:12
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
