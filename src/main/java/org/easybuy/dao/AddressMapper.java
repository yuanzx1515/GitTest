package org.easybuy.dao;

import org.apache.ibatis.annotations.Select;
import org.easybuy.entity.address;
import sun.jvm.hotspot.debugger.Address;

import java.util.List;

public interface AddressMapper {

    @Select("select * from address where A_id = #{A_id}")
    List<Address> selectByAId(int A_id);

}
