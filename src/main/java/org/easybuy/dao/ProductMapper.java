package org.easybuy.dao;

import org.apache.ibatis.annotations.Select;
import org.easybuy.entity.product;

import java.util.List;

public interface ProductMapper {
    @Select("select * from  product")
    List<product> selectAll();

}
