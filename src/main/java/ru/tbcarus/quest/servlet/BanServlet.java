package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.model.User;
import ru.tbcarus.quest.service.UserService;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;

@WebServlet(urlPatterns = Constants.PATH_BAN)
@RequiredArgsConstructor
public class BanServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Constants.USER);
        session.invalidate();
        userService.deleteUser(user);
        req.getRequestDispatcher(Constants.VIEW_BAN).forward(req, resp);
    }
}
