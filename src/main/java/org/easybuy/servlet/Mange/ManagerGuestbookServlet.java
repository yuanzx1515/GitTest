package org.easybuy.servlet.Mange;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.entity.Guestbook;
import org.easybuy.service.GuestbookService;
import org.easybuy.service.UserService;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;


@WebServlet("/ManagerGuestbook")
public class ManagerGuestbookServlet extends HttpServlet {
    GuestbookService guestbookService;

    @Override
    public void init() throws ServletException {
        guestbookService = new GuestbookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        Context context = new Context();
        context.setVariable("MassageName", username);
        List<Guestbook> messageList =  guestbookService.GuestBookSelectAll();
        context.setVariable("messageList", messageList);
        ThymeleafUtil.process("ManagerGuestbook.html", context, resp.getWriter());
        }

    }
/**
 *    String username = req.getParameter("username");
 *         if (username != null && !username.isEmpty()) {
 *             userService.deleteUser(username);
 *             resp.sendRedirect(req.getContextPath() + "/user");
 *         } else {
 *             Context context = new Context();
 *             context.setVariable("User_List", userService.getAllUser());
 *             ThymeleafUtil.process("user.html", context, resp.getWriter());
 *         }
 *     }
 */
