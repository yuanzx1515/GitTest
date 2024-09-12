package org.easybuy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easybuy.entity.address;

import java.util.List;

public interface AddressMapper {

    @Select("select * from address where A_id = #{A_id}")
    List<address> selectByAId(int A_id);

    @Insert("insert into address(username,address_line,phone,A_id) values(#{username},#{address_line},#{phone},#{A_id})")
    int insertUser(@Param("username") String username,@Param("address_line")String address_line,@Param("phone")String phone,@Param("A_id")int A_id);


    @Insert("insert into address(username,address_line,phone,A_id) values(#{username},#{address_line},#{phone},#{A_id})")
   int insertUserNoll(@Param("username") String username,@Param("address_line")String address_line,@Param("phone")String phone,@Param("A_id")int A_id);

    @Select("SELECT Add_id FROM address WHERE A_id = #{A_id}")
    List<Integer> findADDByAId(int A_id);

    @Select("select address_line from address where Add_id = #{Add_id}")
    String findADDByAddId(int Add_id);
}
