package org.easybuy.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.easybuy.entity.User;
import org.easybuy.service.ManagerService;
import org.easybuy.service.UserService;

import java.io.IOException;

@WebFilter("/Manage*")
public class Filter extends HttpFilter {
    ManagerService managerService ;
    @Override
    public void init() throws ServletException {
        managerService = new ManagerService();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        boolean user = managerService.findUserByUsername(username);
        if (!user){
            res.sendRedirect(req.getContextPath() + "index");
        }else {
            chain.doFilter(req, res);
        }


    }
}
