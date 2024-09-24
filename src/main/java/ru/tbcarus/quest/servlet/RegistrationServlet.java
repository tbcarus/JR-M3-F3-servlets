package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.model.User;
import ru.tbcarus.quest.service.UserService;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = Constants.PATH_REGISTRATION)
public class RegistrationServlet extends HttpServlet {

    private UserService userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.VIEW_REGISTRATION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Constants.LOGIN);
        String password = req.getParameter(Constants.PASSWORD);
        User user = new User(UUID.randomUUID(), login, password);
        userService.saveUser(user);

        resp.sendRedirect(Constants.PATH_LOGIN);
    }
}
