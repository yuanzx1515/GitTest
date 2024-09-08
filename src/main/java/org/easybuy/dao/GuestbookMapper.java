package org.easybuy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easybuy.entity.Guestbook;

import java.util.List;

public interface GuestbookMapper {


    @Insert("INSERT INTO guestbook (username, content) VALUES (#{username}, #{content})")
    void insertMessage(@Param("username") String username, @Param("content") String content);

    @Select("select * from guestbook")
    List<Guestbook> GuestBookSelectAll();

    @Select("SELECT * FROM guestbook LIMIT #{limit} OFFSET #{offset}")
    List<Guestbook> selectGuestbookPage(@Param("limit") int limit, @Param("offset") int offset);


    @Select("SELECT COUNT(*) FROM guestbook")
    int countGuestbook();


    @Delete("DELETE FROM guestbook WHERE G_ID = #{G_ID}")
    void deleteGuestbookById(int G_ID);
}



