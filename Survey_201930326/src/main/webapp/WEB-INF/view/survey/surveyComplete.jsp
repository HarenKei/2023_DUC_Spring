<%--
  Created by IntelliJ IDEA.
  User: harenkei
  Date: 2023/04/14
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>응답</h1>
    <p>1: ${surveyCommand.q1}</p>
    <p>2: ${surveyCommand.q2}</p>
    <p>3: ${surveyCommand.q3}</p>
    <p><spring:message code="survey.respondentName"/> : ${surveyCommand.respondentName}</p>
    <p><spring:message code="survey.respondentAge"/> ${surveyCommand.respondentAge}</p>
    <a href="<c:url value='/survey/surveyList'/>">[응답 리스트 보기]</a>
</body>
</html>
