<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB</title>
</head>
<body>

<h1>Welcome to knuMovieDB</h1>

<h2>Login</h2>

<form method="post" action="../func/SignInAction.jsp">
     <input type="text" class="form-control" placeholder="아이디" name="id" maxlength="20">
     <input type="password" class="form-control" placeholder="비밀번호" name="pw" maxlength="20">
<input type="submit" class="btn btn-primary form-control" value="로그인">
</form>

<br>
    회원가입 > <a href="../view/SignUp.jsp">Sign Up</a>
</body>
</html>
