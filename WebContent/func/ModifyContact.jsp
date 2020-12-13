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
	String contact = request.getParameter("contact");
	
	boolean contact_check = true;

	if (contact.length() != 13) {
		contact_check = false;
	} else {
		for (int i = 0; i <= 12; i++) {
			if (i == 3 || i == 8) {
				if (contact.charAt(i) != '-')
					contact_check = false;
			} else {
				if (contact.charAt(i) >= '0' && contact.charAt(i) <= '9') {
				} else {
					contact_check = false;
				}
			}
		}
	}

	if (contact_check == false) {
		out.println("<script>");
		out.println("alert('전화번호 입력이 올바르지 않습니다.');");
		out.println("history.back();");
		out.println("</script>");
	}else{
		AccountDAO dao = new AccountDAO();
		 
		 if(dao.modify_info(session.getAttribute("username").toString(), "CONTACT", contact)){
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
	}
	
	
%>

</body>
</html>