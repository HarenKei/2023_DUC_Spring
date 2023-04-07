<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
</head>
<body>
<h2>Step2 - 회원정보 입력</h2>
<form action="step3" method="post">
  <p>
    <label for="email">이메일 : </label>
    <input type="text" name="email" id="email" />
  </p>
  <p>
    <label for="name">이름 : </label>
    <input type="text" name="name" id="name" />
  </p>
  <p>
    <label for="password">비밀번호 : </label>
    <input type="password" name="password" id="password" />
  </p>
  <p>
    <label for="confirmPassword">비밀번호 확인 : </label>
    <input type="password" name="confirmPassword" id="confirmPassword" />
  </p>
  <input type="submit" value="가입 완료" />
</form>
</body>
</html>