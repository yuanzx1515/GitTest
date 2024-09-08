package org.easybuy.service;

import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.AddressMapper;
import org.easybuy.service.Impl.AddressServiceImpl;
import sun.jvm.hotspot.debugger.Address;

import java.util.List;

public class AddressService implements AddressServiceImpl {

    @Override
    public List<Address> selectByAId(int A_id) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            return addressMapper.selectByAId(A_id);
        }
    }
}
