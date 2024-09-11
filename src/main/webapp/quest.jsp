<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="ru.tbcarus.quest.model.Phase" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.lang.String" %>

<%--<%@ page import="ru.tbcarus.quest.model.Stage" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>${questName}</title>
</head>

<body>
<jsp:useBean id="stage" type="ru.tbcarus.quest.model.Stage" scope="request"/>
<c:if test="${stage.id == 0}">
    <div>
        <h3>
            Введение
        </h3>
    </div>
    <div>
            ${intro}
    </div>
</c:if>
<div>
    ${stage.description}
</div>

<c:forEach var="child" items="${stage.toChildrenStages.entrySet()}">
    <jsp:useBean id="child" type="java.util.Map.Entry"/>
    <button onclick="window.location.href = 'quest?stageId=${child.key}'">${child.value}</button>
</c:forEach>

<c:if test="${stage.phase == Phase.WIN || stage.phase == Phase.LOSE}">
    <button onclick="window.location.href = 'quest?stageId=0&restart'">Сначала</button>
    <button onclick="window.location.href = 'start'">К выбору</button>
</c:if>
</body>
</html>