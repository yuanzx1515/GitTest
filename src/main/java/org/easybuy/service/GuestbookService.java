package org.easybuy.service;

import org.apache.ibatis.session.SqlSession;
import org.easybuy.Util.MybatisUtil;
import org.easybuy.dao.GuestbookMapper;
import org.easybuy.dao.UserMapper;
import org.easybuy.entity.Guestbook;
import org.easybuy.service.Impl.GuestbookServiceImpl;

import java.util.List;

public class GuestbookService implements GuestbookServiceImpl {
    @Override
    public void insertMessage(String username, String content) {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            GuestbookMapper guestbookMapper = session.getMapper(GuestbookMapper.class);
            guestbookMapper.insertMessage(username, content);
        }
    }

    @Override
    public List<Guestbook> GuestBookSelectAll() {
        try(SqlSession session = MybatisUtil.getSqlSessionFactory()){
            GuestbookMapper guestbookMapper = session.getMapper(GuestbookMapper.class);
            return guestbookMapper.GuestBookSelectAll();
        }
    }

    public List<Guestbook> getGuestbookPage(int page, int pageSize) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            GuestbookMapper guestbookMapper = session.getMapper(GuestbookMapper.class);


            int offset = (page - 1) * pageSize;

            return guestbookMapper.selectGuestbookPage(pageSize, offset);
        }
    }

    public int getGuestbookCount() {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            GuestbookMapper guestbookMapper = session.getMapper(GuestbookMapper.class);
            return guestbookMapper.countGuestbook();
        }
    }

    @Override
    public void  deleteGuestbookById(int G_ID){
     try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
         GuestbookMapper guestbookMapper = session.getMapper(GuestbookMapper.class);
         guestbookMapper.deleteGuestbookById(G_ID);
     }
    }
}
