package org.easybuy.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取会话对象
        HttpSession session = req.getSession(false); // 获取当前会话，如果没有会话则返回null
        if (session != null) {
            session.invalidate(); // 销毁会话，注销用户
        }
        // 重定向到登录页面或者主页
        resp.sendRedirect("login");
    }
}
