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
	String name = request.getParameter("name");
	


	if (name.replaceAll(" ", "").equals("")) {
		out.println("<script>");
		out.println("alert('������ �̸� �Է��� �ùٸ��� �ʽ��ϴ�.');");
		out.println("history.back();");
		out.println("</script>");
	}else{
		AccountDAO dao = new AccountDAO();
		 
		 if(dao.modify_info(session.getAttribute("username").toString(), "NAME", name)){
			 out.println("<script>");
				out.println("alert('������� ���� ����.');");
				out.println("location.href='../view/Mypage.jsp';");
				out.println("</script>");
		 }else{
			 	out.println("<script>");
				out.println("alert('������� ���� ����.');");
				out.println("history.back();");
				out.println("</script>");
		 }
	}
	
	
%>

</body>
</html>