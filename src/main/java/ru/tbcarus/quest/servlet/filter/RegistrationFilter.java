package ru.tbcarus.quest.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.tbcarus.quest.model.ErrorMessage;
import ru.tbcarus.quest.service.validation.LoginValidationExecutor;
import ru.tbcarus.quest.service.validation.LoginValidator;
import ru.tbcarus.quest.service.validation.PasswordValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "/registration")
public class RegistrationFilter implements Filter {

    private LoginValidator loginValidator;
    private PasswordValidator passwordValidator;
    private LoginValidationExecutor loginValidationExecutor;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ServletContext servletContext = filterConfig.getServletContext();
        loginValidator = (LoginValidator) servletContext.getAttribute("loginValidator");
        passwordValidator = (PasswordValidator) servletContext.getAttribute("passwordValidator");
        loginValidationExecutor = (LoginValidationExecutor) servletContext.getAttribute("loginValidationExecutor");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getMethod().equals("GET")) {
            filterChain.doFilter(req, resp);
        }

        if (req.getMethod().equals("POST")) {
            Map<String, String> fields = new HashMap<>();
            fields.put("login", req.getParameter("login"));
            fields.put("password", req.getParameter("password"));

            List<ErrorMessage> errorMessages = loginValidationExecutor.validate(fields);
            if (errorMessages.isEmpty()) {
                filterChain.doFilter(req, resp);
            } else {
                req.setAttribute("errors", errorMessages);
                req.getRequestDispatcher("/registration.jsp").forward(req, resp);
            }
        }

    }
}