package ru.tbcarus.quest.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.model.Phase;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;

import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = {"/ban"})
public class BanFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Boolean isBan = (Boolean) session.getAttribute("isBan");
        if (isBan != null && isBan) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }
}