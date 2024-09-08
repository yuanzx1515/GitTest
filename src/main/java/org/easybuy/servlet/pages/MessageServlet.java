package org.easybuy.servlet.pages;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.entity.Guestbook;
import org.easybuy.entity.User;
import org.easybuy.service.GuestbookService;
import org.easybuy.service.UserService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook")
public class MessageServlet extends HttpServlet {
        GuestbookService service;

    @Override
    public void init() throws ServletException {
       service = new GuestbookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        Context context = new Context();
        context.setVariable("MassageName", username);
        List<Guestbook> messageList = service.GuestBookSelectAll();
        context.setVariable("messageList", messageList);
        ThymeleafUtil.process("guestbook.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
       String content = req.getParameter("guestContent");
       service.insertMessage(username, content);
       resp.sendRedirect( "guestbook");
    }
}
