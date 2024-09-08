package org.easybuy.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.easybuy.entity.User;

public interface ManagerMapper {
    @Select("SELECT a.username, a.password, a.mobile " +
            "FROM admin a " +
            "JOIN manager m ON a.username = m.username " +
            "WHERE a.username = #{username} " +
            "LIMIT 1")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "mobile", column = "mobile")
    })
    User findUserByUsername(@Param("username") String username);


    @Select("SELECT a.username, a.password, a.mobile " +
            "FROM admin a " +
            "JOIN manager m ON a.username = m.username " +
            "WHERE a.username = #{username} " +
            "LIMIT 1")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "mobile", column = "mobile")
    })
    User findMangerUser(@Param("username") String username);

}
