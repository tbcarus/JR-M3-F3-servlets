package ru.tbcarus.quest.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.tbcarus.quest.model.ErrorMessage;
import ru.tbcarus.quest.service.validation.LoginValidationExecutor;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = Constants.PATH_REGISTRATION)
public class RegistrationFilter implements Filter {

    private LoginValidationExecutor loginValidationExecutor;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ServletContext servletContext = filterConfig.getServletContext();
        loginValidationExecutor = (LoginValidationExecutor) servletContext.getAttribute(Constants.LOGIN_VALIDATION_EXECUTOR);
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
            fields.put(Constants.LOGIN, req.getParameter(Constants.LOGIN));
            fields.put(Constants.PASSWORD, req.getParameter(Constants.PASSWORD));

            List<ErrorMessage> errorMessages = loginValidationExecutor.validate(fields);
            if (errorMessages.isEmpty()) {
                filterChain.doFilter(req, resp);
            } else {
                req.setAttribute(Constants.ERRORS, errorMessages);
                req.getRequestDispatcher(Constants.VIEW_REGISTRATION).forward(req, resp);
            }
        }

    }
}