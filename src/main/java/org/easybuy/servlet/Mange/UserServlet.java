package org.easybuy.servlet.Mange;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.service.UserService;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (username != null && !username.isEmpty()) {
            userService.deleteUser(username);
            resp.sendRedirect(req.getContextPath() + "/user");
        } else {
            Context context = new Context();
            context.setVariable("User_List", userService.getAllUser());
            ThymeleafUtil.process("user.html", context, resp.getWriter());
        }
    }
}