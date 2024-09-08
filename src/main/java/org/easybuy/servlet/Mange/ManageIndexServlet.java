package org.easybuy.servlet.Mange;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.service.ManagerService;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/ManageIndex")
public class ManageIndexServlet extends HttpServlet {
    ManagerService managerService;
    @Override
    public void init() throws ServletException {
        managerService = new ManagerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        context.setVariable("ManageName", username);
        boolean userByUsername = managerService.findUserByUsername(username);
        context.setVariable("ManageUser", userByUsername);
        System.out.println(userByUsername);
        ThymeleafUtil.process("ManageIndex.html",context,resp.getWriter());
    }
}
