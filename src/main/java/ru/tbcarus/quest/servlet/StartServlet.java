package ru.tbcarus.quest.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.config.Configs;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.service.QuestService;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;

@WebServlet(name = "startServlet", value = Constants.PATH_START)
public class StartServlet extends HttpServlet {

    private QuestService questService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        questService = (QuestService) servletContext.getAttribute(Constants.QUEST_SERVICE);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute(Constants.QUEST_LIST, Configs.getConfigs().getQuestMapConfig().getQuestNameList());

        request.getRequestDispatcher(Constants.VIEW_START).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String questName = request.getParameter(Constants.QUEST_NAME);
        Quest quest = questService.getQuest(questName);
        HttpSession session = request.getSession();
        session.setAttribute(Constants.QUEST, quest);
        session.setAttribute(Constants.CURRENT_STAGE_ID, 0);

        response.sendRedirect("quest?stageId=0");
    }
}