package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.model.User;
import ru.tbcarus.quest.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        passwordEncoder = (BCryptPasswordEncoder) servletContext.getAttribute("passwordEncoder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.getUser(login, password);
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }
        resp.sendRedirect("/start");
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
    }
}
