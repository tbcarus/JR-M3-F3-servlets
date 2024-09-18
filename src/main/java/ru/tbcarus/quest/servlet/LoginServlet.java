package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.model.User;
import ru.tbcarus.quest.service.UserService;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = Constants.PATH_LOGIN)
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.VIEW_LOGIN).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Constants.LOGIN);
        String password = req.getParameter(Constants.PASSWORD);

        Optional<User> user = userService.getUser(login, password);
        if (user.isEmpty()) {
            resp.sendRedirect(Constants.PATH_LOGIN);
            return;
        }
        resp.sendRedirect(Constants.PATH_START);
        HttpSession session = req.getSession();
        session.setAttribute(Constants.USER, user.get());
    }
}
