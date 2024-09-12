package org.easybuy.service;

import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.AddressMapper;
import org.easybuy.entity.address;
import org.easybuy.service.Impl.AddressServiceImpl;

import java.util.List;

public class AddressService implements AddressServiceImpl {

    @Override
    public List<address> selectByAId(int A_id) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
          return   addressMapper.selectByAId(A_id);
        }
    }

    @Override
    public void addAddress(String username, String address_line, String phone, int A_id) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            addressMapper.insertUser(username, address_line, phone, A_id);
        }
    }

    @Override
    public boolean insertUserNoll(String username, String address_line, String phone, int A_id) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            int address = addressMapper.insertUserNoll(username, address_line, phone, A_id);
            if (address == 0) return false;
            return true;
        }
    }

    @Override
    public List<Integer> findADDByAId(int A_id) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            return addressMapper.findADDByAId(A_id);
        }
    }

    @Override
    public String findADDByAddId(int Add_id) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()){
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            return addressMapper.findADDByAddId(Add_id);
        }
    }

}
