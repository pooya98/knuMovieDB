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
	String birth = request.getParameter("birth");
	
	boolean birth_check = true;
	
	if (birth.replaceAll(" ", "").length() > 0) {
		if (birth.length() != 10) {
			birth_check = false;
		}
		else{
			for (int i = 0; i <= 9; i++) {
				if (i == 4 || i == 7) {
					if (birth.charAt(i) != '-'){
						birth_check = false;
						break;
					}
				} else {
					if (birth.charAt(i) >= '0' && birth.charAt(i) <= '9') {

					} else {
						birth_check = false;
						break;
					}
				}
			}
		}
	}else{
		birth="(�Է¾���)";
	}
	
	if(birth_check){
		AccountDAO dao = new AccountDAO();
		 
		 if(dao.modify_info(session.getAttribute("username").toString(), "BIRTH", birth)){
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
		out.println("alert('��ȿ���� ���� ������� �Է��Դϴ�.');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	
%>

</body>
</html>