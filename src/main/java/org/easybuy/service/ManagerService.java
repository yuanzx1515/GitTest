package org.easybuy.service;

import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.ManagerMapper;
import org.easybuy.entity.User;
import org.easybuy.entity.manager;
import org.easybuy.service.Impl.ManagerMapperImpl;

public class ManagerService implements ManagerMapperImpl {
    @Override
    public boolean findUserByUsername(String username) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            User userByUsername = mapper.findUserByUsername(username);
            if (userByUsername == null) return false;
            return true;
        }
    }

    @Override
    public boolean findMangerUser(String username) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
           User mangerUser = mapper.findMangerUser(username);
            if (mangerUser != null)
                return true;
            return false;
        }
    }
}


