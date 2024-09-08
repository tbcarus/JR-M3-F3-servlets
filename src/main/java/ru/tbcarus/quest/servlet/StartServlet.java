package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.config.Configs;
import ru.tbcarus.quest.model.Quest;

import java.io.IOException;

@WebServlet(name = "startServlet", value = "/start")
public class StartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("questList", Configs.getConfigs().getQuestMapConfig().getQuestNameList());

        request.getRequestDispatcher("start.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String questName = request.getParameter("questName");
        Quest quest = Configs.getQuest(questName);
        HttpSession session = request.getSession();
        session.setAttribute("quest", quest);
        session.setAttribute("verStageId", 0);

        response.sendRedirect("quest?stageId=0");
    }
}