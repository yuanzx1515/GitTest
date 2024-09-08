package org.easybuy.servlet.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.entity.product;
import org.easybuy.service.ProductService;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;

@WebServlet("/productview")
public class ProductView extends HttpServlet {
    ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();

        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        context.setVariable("ProduCtuSername", username);

        List<product> products = productService.selectAll();
        context.setVariable("ProductList",products);



        ThymeleafUtil.process("productview.html",context,resp.getWriter());
    }
}
