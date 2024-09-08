package org.easybuy.service;

import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.ProductMapper;
import org.easybuy.entity.product;
import org.easybuy.service.Impl.ProductServiceImpl;

import java.util.List;

public class ProductService implements ProductServiceImpl {
    @Override
    public List<product> selectAll() {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            return mapper.selectAll();
        }
    }
}
