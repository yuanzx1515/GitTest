package org.easybuy.servlet.Mange;

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

@WebServlet("/usermodify")
public class UserModify extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThymeleafUtil.process("usermodify.html",new Context(),resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");
        String confirmPassword = req.getParameter("confirmPassword");
        String address = req.getParameter("address");
        if(password.equals(confirmPassword)) {
            userService.updateUser(username,password,mobile,address);
            resp.sendRedirect("user");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("error","Passwords do not match");
        }
    }
}
