package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;

@WebServlet(name = "questServlet", value = Constants.PATH_QUEST)
public class QuestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Quest quest = (Quest) session.getAttribute(Constants.QUEST);
        int nextStageId = Integer.parseInt(request.getParameter(Constants.STAGE_ID));
        Stage stage = quest.getStage(nextStageId);

        request.setAttribute(Constants.INTRO, quest.getStory());
        request.setAttribute(Constants.QUEST_NAME, quest.getName());
        request.setAttribute(Constants.STAGE, stage);
        session.setAttribute(Constants.CURRENT_STAGE_ID, nextStageId);

        request.getRequestDispatcher(Constants.VIEW_QUEST).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}