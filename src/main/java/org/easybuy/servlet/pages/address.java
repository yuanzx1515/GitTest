package org.easybuy.servlet.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.service.AddressService;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/address")
public class address  extends HttpServlet {
        AddressService addressService;

    @Override
    public void init() throws ServletException {
        addressService = new AddressService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();

        ThymeleafUtil.process("address.html",context,resp.getWriter());

    }
}
