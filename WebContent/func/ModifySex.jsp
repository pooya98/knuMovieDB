<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.CheckUser, model.AccountDAO, model.AccountDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String sex = request.getParameter("sex");
	


	if (sex.equals("No")) {
		sex="(입력없음)";
	}
	
	AccountDAO dao = new AccountDAO();
		 
	 if(dao.modify_info(session.getAttribute("username").toString(), "SEX", sex)){
		out.println("<script>");
		out.println("alert('변경사항 저장 성공.');");
		out.println("location.href='../view/Mypage.jsp';");
		out.println("</script>");
	 }else{
		out.println("<script>");
		out.println("alert('변경사항 저장 실패.');");
		out.println("history.back();");
		out.println("</script>");
	 }

	
	
%>

</body>
</html>