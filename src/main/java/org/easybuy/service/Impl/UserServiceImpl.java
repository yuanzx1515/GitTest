package org.easybuy.service.Impl;

import jakarta.servlet.http.HttpSession;
import org.easybuy.entity.User;

import java.util.List;

public interface  UserServiceImpl {
    boolean auth(String username, String password, HttpSession session);
    void register(String username, String password, String mobile, HttpSession session);
   List<User> getAllUser();
   void deleteUser(String username);
    int updateUser(String username, String password, String mobile, String address);

}
