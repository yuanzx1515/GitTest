package org.easybuy.dao;

import org.apache.ibatis.annotations.*;
import org.easybuy.entity.User;

import java.util.List;

public interface UserMapper {
    @Select("select  * from admin where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username,@Param("password") String password);

    @Insert("INSERT into admin(username,password,mobile) VALUES(#{username},#{password},#{mobile})")
    int addUser(@Param("username") String username,@Param("password") String password,@Param("mobile") String mobile);

    @Select("SELECT * FROM admin WHERE username != 'yuanzx'")
    List<User> getAllUser();

    @Delete("DELETE FROM admin WHERE username = #{username}")
    void deleteUser(@Param("username") String username);


    @Update("UPDATE admin SET password = #{password}, mobile = #{mobile}, address = #{address} WHERE username = #{username}")
    int updateUser(@Param("username") String username,
                   @Param("password") String password,
                   @Param("mobile") String mobile,
                   @Param("address") String address);



        @Select("SELECT U_id FROM admin WHERE username = #{username}")
        Integer getUserByUsername(String username);

}

