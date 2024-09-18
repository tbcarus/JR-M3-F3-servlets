package ru.tbcarus.quest.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.tbcarus.quest.model.Phase;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;
import ru.tbcarus.quest.util.Constants;

import java.io.IOException;

@WebFilter(urlPatterns = {Constants.PATH_QUEST})
public class QuestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Quest quest = (Quest) session.getAttribute(Constants.QUEST);
        int currentStageId = (int) session.getAttribute(Constants.CURRENT_STAGE_ID);
        int stageId = Integer.parseInt(req.getParameter(Constants.STAGE_ID));
        Stage stage = quest.getStage(currentStageId);


        if ((currentStageId == stageId && currentStageId == 0)
            || stage.getToChildrenStages().containsKey(stageId)
            || currentStageId == stageId
            || stageId == 0 && (stage.getPhase() == Phase.LOSE || stage.getPhase() == Phase.WIN)) {
            session.setAttribute(Constants.IS_BAN, true);
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(Constants.PATH_BAN);
        }
    }
}