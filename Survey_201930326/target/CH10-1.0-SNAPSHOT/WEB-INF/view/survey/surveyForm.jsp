<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step2 - 회원정보 입력</h2>
<form:form action="surveyComplete" modelAttribute="surveyForm">
<form action="surveyComplete" method="post">
    <p>
        <label for="q1">우왕: </label>
        <form:radiobutton path="q1" value="server"/> 서버개발자
        <form:radiobutton path="q1" value="frontend"/> 프론트개발자
        <form:radiobutton path="q1" value="fullstack"/> 풀스택개발자
        <form:errors path="q1" />
    </p>
    <p>
        <label for="q2">똥: </label>
        <form:radiobutton path="q2" value="eclipse"/>  Eclipse
        <form:radiobutton path="q2" value="intellij"/> IntelliJ
        <form:radiobutton path="q2" value="vscode"/> VSCode
        <form:errors path="q2" />
    </p>
    <p>
        <label for="q3">웩: </label>
        <form:input path="q3"/>
        <form:errors path="q3" />
    </p>
    <p>
        <label for="respondentName">ㅅㅅ: </label>
        <form:input path="respondentName"/>
        <form:errors path="respondentName" />
    </p>

    <p>
        <label for="respondentAge">ㅅㅅ: </label>
        <form:input path="respondentAge"/>
        <form:errors path="respondentAge" />
    </p>

    <input type="submit" value="전송" />
    </form:form>
</body>
</html>