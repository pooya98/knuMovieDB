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
	request.setCharacterEncoding("UTF-8");
	String cur_password = request.getParameter("cur_password");
	String new_password = request.getParameter("new_password");
	String new_password_check = request.getParameter("new_password_check");
	
	
	boolean password_check = true;
	
	CheckUser cu = new CheckUser();
	
	if(!cu.Exist(session.getAttribute("username").toString(), cur_password)){
		out.println("<script>");
		out.println("alert('���� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.');");
		out.println("history.back();");
		out.println("</script>");
		password_check = false;
	}
	
	if(password_check && new_password.replaceAll(" ", "").equals("")){
		out.println("<script>");
		out.println("alert('���ο� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.');");
		out.println("history.back();");
		out.println("</script>");
		password_check = false;
	}
	
	if(password_check){
		if(new_password.equals(new_password_check)){
			AccountDAO dao = new AccountDAO();
			 
			 if(dao.modify_info(session.getAttribute("username").toString(), "PASSWORD", new_password)){
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
		}else{
			out.println("<script>");
			out.println("alert('���ο� ��й�ȣ Ȯ���� �ùٸ��� �ʽ��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
	
	
%>

</body>
</html>