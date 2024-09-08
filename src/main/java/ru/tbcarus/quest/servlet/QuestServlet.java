package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.config.Configs;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;

import java.io.IOException;

@WebServlet(name = "questServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Quest quest = (Quest) session.getAttribute("quest");
        int verStageId = (int) session.getAttribute("verStageId");
        int stageId = Integer.parseInt(request.getParameter("stageId"));
        Stage stage = quest.getStage(stageId);

        request.setAttribute("intro", quest.getStory());
        request.setAttribute("questName", quest.getName());
        request.setAttribute("stage", stage);
        session.setAttribute("verStageId", stageId);

        request.getRequestDispatcher("quest.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String questName = request.getParameter("questName");
        Quest quest = Configs.getQuest(questName);


        response.sendRedirect("quest?stageN=0");
    }

    public boolean checkCheat(Quest quest, int verStageId, int stageId) {
        /* true, если
        1. verStageId = stageId = 0
        2. У текущей стадии с ID verStageId есть потомки с ID stageId
         */


        return true;
    }
}