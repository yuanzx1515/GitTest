package org.easybuy.service.Impl;

import org.easybuy.entity.Guestbook;

import java.util.List;

public interface GuestbookServiceImpl {
    void insertMessage(String username,String content);
    List<Guestbook> GuestBookSelectAll();
    List<Guestbook> getGuestbookPage(int page, int pageSize);
    int getGuestbookCount();
    void deleteGuestbookById(int G_ID);
}
