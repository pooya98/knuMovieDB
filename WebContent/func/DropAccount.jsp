<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.CheckUser, model.AccountDAO, model.AccountDTO, model.CheckUser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB</title>
</head>
<body>
<%
	AccountDAO dao = new AccountDAO();

			 if(dao.dropAccount(session.getAttribute("username").toString())){
				 out.println("<script>");
					out.println("alert('회원탈퇴 성공.');");
					out.println("location.href='../view/SignIn.jsp';");
					out.println("</script>");
			 }else{
				 	out.println("<script>");
					out.println("alert('회원탈퇴 실패.');");
					out.println("history.back();");
					out.println("</script>");
			 }

	
	
%>

</body>
</html>