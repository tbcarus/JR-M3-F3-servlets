package ru.tbcarus.quest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.dao.UserDao;
import ru.tbcarus.quest.service.UserService;

import java.io.File;

@WebListener
public class InitializationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        File file = new File("C:/projects/JR/Module-3/JR-M3-F3-servlets/src/main/resources/Users.yaml");

        UserDao userDao = new UserDao(objectMapper, file);
        UserService userService = new UserService(userDao, new BCryptPasswordEncoder());

        servletContext.setAttribute("userService", userService);
//        servletContext.setAttribute("objectMapper", objectMapper);

        servletContext.setAttribute("passwordEncoder", new BCryptPasswordEncoder());
    }
}
