package ru.tbcarus.quest.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.model.Phase;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;

import java.io.IOException;

@WebFilter(urlPatterns = {"/quest"})
public class QuestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Quest quest = (Quest) session.getAttribute("quest");
        int verStageId = (int) session.getAttribute("verStageId");
        int stageId = Integer.parseInt(req.getParameter("stageId"));
        Stage stage = quest.getStage(verStageId);


        if ((verStageId == stageId && verStageId == 0)
            || stage.getToChildrenStages().containsKey(stageId)
            || verStageId == stageId
            || verStageId == 0 && (stage.getPhase() == Phase.LOSE || stage.getPhase() == Phase.WIN)) {
            session.setAttribute("isBan", true);
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/ban");
        }
    }
}