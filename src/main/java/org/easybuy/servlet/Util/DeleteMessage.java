package org.easybuy.servlet.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.easybuy.service.GuestbookService;

import java.io.IOException;

@WebServlet("/deleteMessage")
public class DeleteMessage  extends HttpServlet {
    GuestbookService guestbookService;
    @Override
    public void init() throws ServletException {
        guestbookService = new GuestbookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);

        // 调用 Service 方法删除记录
        guestbookService.deleteGuestbookById(id);

        // 删除成功后重定向到留言列表页面
        resp.sendRedirect("ManagerGuestbook");
    }
}
