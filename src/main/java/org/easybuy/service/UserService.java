package org.easybuy.service;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.UserMapper;
import org.easybuy.entity.User;
import org.easybuy.service.Impl.UserServiceImpl;

import java.util.List;

public class UserService implements UserServiceImpl {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }

    @Override
    public void register(String username, String password, String mobile, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
          int user = userMapper.addUser(username, password, mobile);
            if (user > 0) {
                sqlSession.commit();
                session.setAttribute("username", username);
            }else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                    return userMapper.getAllUser();
        }
    }

    @Override
    public void deleteUser(String username) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(username);
        }
    }

    @Override
    public int updateUser(String username, String password, String mobile, String address) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.updateUser(username, password, mobile, address);
        }
    }

    @Override
    public Integer getUserByUsername(String username) {
       try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory()) {
           UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
           return userMapper.getUserByUsername(username);
       }
    }


}
