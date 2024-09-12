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

@WebFilter("/productview")
public class Filter extends HttpFilter {
    UserService userService;
    @Override
    public void init() throws ServletException {
       userService = new UserService();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
      if (username == null) {
          res.sendRedirect(req.getContextPath() + "/login");
      }else
          chain.doFilter(req, res);
    }
}
