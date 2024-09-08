package org.easybuy.servlet.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.Util.ThymeleafUtil;
import org.easybuy.entity.product;
import org.easybuy.service.ManagerService;
import org.easybuy.service.ProductService;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    ProductService productService;
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Thymeleaf上下文
        Context context = new Context();

        // 获取HttpSession对象
        HttpSession session = req.getSession();

        // 从Session中获取用户名
        String username = (String) session.getAttribute("username");

        // 将用户名添加到Thymeleaf的上下文中
        context.setVariable("username", username);
        ManagerService service = new ManagerService();
        boolean userByUsername = service.findUserByUsername(username);
        context.setVariable("ManageUser", userByUsername);

        List<product> products = productService.selectAll();
        context.setVariable("ProductList",products);


        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
}

