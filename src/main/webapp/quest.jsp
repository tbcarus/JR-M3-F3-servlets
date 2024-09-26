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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>${questName}</title>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<div class="container-sm bg-light py-4 text-center">

    <jsp:useBean id="stage" type="ru.tbcarus.quest.model.Stage" scope="request"/>
    <c:if test="${stage.id == 0}">
        <div class="row pb-3 mb-3 d-flex justify-content-center alert alert-primary">
            <div>
                <p class="fs-1">Введение</p>
            </div>
            <div>
                    ${intro}
            </div>
        </div>
    </c:if>

    <div class="row pb-3 mb-3 d-flex justify-content-center alert
    ${stage.phase == Phase.NEXT ? 'alert-info' :
    stage.phase == Phase.WIN ? 'alert-success' : 'alert-danger'}">
        ${stage.description}
    </div>

    <div class="">
        <c:forEach var="child" items="${stage.toChildrenStages.entrySet()}">
            <jsp:useBean id="child" type="java.util.Map.Entry"/>
            <button class="btn btn-primary ms-2 me-2"
                    onclick="window.location.href = 'quest?stageId=${child.key}'">${child.value}</button>
        </c:forEach>

        <c:if test="${stage.phase == Phase.WIN || stage.phase == Phase.LOSE}">
            <button class="btn btn-primary ms-2 me-2" onclick="window.location.href = 'quest?stageId=0&restart'">
                Сначала
            </button>
            <button class="btn btn-primary ms-2 me-2" onclick="window.location.href = 'start'">К выбору</button>
        </c:if>
    </div>
</div>
</body>
</html>