package com.github.yingzhuo.spring.examples.mybatis.mapper;

import com.github.yingzhuo.spring.examples.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from T_USER WHERE id = #{id}")
    public User findById(@Param("id") String id);

}
