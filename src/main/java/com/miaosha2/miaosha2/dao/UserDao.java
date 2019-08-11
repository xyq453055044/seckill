package com.miaosha2.miaosha2.dao;

import com.miaosha2.miaosha2.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xyq
 * @date 2019/08/02
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getById(@Param("id") int id);

    @Insert("insert into user (name) values(#{name})")
    int insert(User user);
}
