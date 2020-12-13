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
		out.println("alert('현재 비밀번호가 올바르지 않습니다.');");
		out.println("history.back();");
		out.println("</script>");
		password_check = false;
	}
	
	if(password_check && new_password.replaceAll(" ", "").equals("")){
		out.println("<script>");
		out.println("alert('새로운 비밀번호가 올바르지 않습니다.');");
		out.println("history.back();");
		out.println("</script>");
		password_check = false;
	}
	
	if(password_check){
		if(new_password.equals(new_password_check)){
			AccountDAO dao = new AccountDAO();
			 
			 if(dao.modify_info(session.getAttribute("username").toString(), "PASSWORD", new_password)){
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
		}else{
			out.println("<script>");
			out.println("alert('새로운 비밀번호 확인이 올바르지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
	
	
%>

</body>
</html>