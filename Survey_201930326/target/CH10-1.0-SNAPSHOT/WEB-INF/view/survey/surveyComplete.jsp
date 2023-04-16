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
    <p>1: <spring:message code="login.done" arguments="${surveyCommand.q1}"/></p>
    <p>2: <spring:message code="login.done" arguments="${surveyCommand.q2}"/></p>
    <p>3: <spring:message code="login.done" arguments="${surveyCommand.q3}"/></p>
    <p>응답자 이름: <spring:message code="login.done" arguments="${surveyCommand.respondentName}"/></p>
    <p>응답자 이름: <spring:message code="login.done" arguments="${surveyCommand.respondentAge}"/></p>
    <a href="<c:url value='/survey/surveyList'/>">[응답 리스트 보기]</a>
</body>
</html>
