<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovie</title>
</head>
<body>
<h1>knuMovieDB</h1>

<%
	R_class rc = new R_class();

	String username = rc.get("client_username").toString();

	out.println("<h3>"+username+" 관리자님, 환영합니다."+"</h3>");
%>
<form method="post" action="../func/SignInAction.jsp">
    <a href="../view/SignUp.jsp"></a>
</form>

<br>
    회원가입 > <a href="../view/SignUp.jsp">Sign Up</a>
</body>
</html>