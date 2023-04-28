<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
<h2><spring:message code="survey.title"/></h2>
<form:form action="surveyComplete" method="post" modelAttribute="surveyCommand">
    <p>
        <label for="q1"><spring:message code="survey.q1"/>: </label>
        <form:radiobutton path="q1" value="서버" label="서버개발자"/>
        <form:radiobutton path="q1" value="프론트" label="프론트개발자"/>
        <form:radiobutton path="q1" value="풀스택" label="풀스택개발자"/>
        <br>
        <form:errors path="q1" cssStyle="color: red" />
    </p>
    <p>
        <label for="q2"><spring:message code="survey.q2"/>:</label>
        <form:radiobutton path="q2" value="Eclipse" label="Eclipse"/>
        <form:radiobutton path="q2" value="Intellij" label="IntelliJ"/>
        <form:radiobutton path="q2" value="VSCode" label="VSCode"/>
        <br>
        <form:errors path="q2" cssStyle="color: red" />
    </p>
    <p>
        <label for="q3"><spring:message code="survey.q3"/>:</label>
        <form:input path="q3"/>
        <br>
        <form:errors path="q3" cssStyle="color: red" />
    </p>
    <p>
        <label for="respondentName"><spring:message code="survey.respondentName"/></label>
        <form:input path="respondentName"/>
        <br>
        <form:errors path="respondentName" cssStyle="color: red" />
    </p>

    <p>
        <label for="respondentAge"><spring:message code="survey.respondentAge"/>: </label>
        <form:input path="respondentAge"/>
        <br>
        <form:errors path="respondentAge" cssStyle="color: red"  />
    </p>

    <input type="submit" value="전송"/>
</form:form>
</body>
</html>