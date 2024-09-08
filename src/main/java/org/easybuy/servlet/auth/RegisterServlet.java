package org.easybuy.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.service.UserService;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThymeleafUtil.process("register.html", new Context(), resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String mobile = req.getParameter("mobile");

        // 输出参数到控制台，便于调试
        System.out.println("用户名: " + username);
        System.out.println("密码: " + password);
        System.out.println("确认密码: " + confirmPassword);
        System.out.println("手机: " + mobile);
Context context = new Context();
        if (password.equals(confirmPassword)) {
            userService.register(username, password, mobile, req.getSession());
            resp.sendRedirect("login");
        } else {
            context.setVariable("error",new Object());
            req.setAttribute("error", "密码和确认密码不一致");
            resp.sendRedirect("register");
        }
    }
}