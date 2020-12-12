<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.CheckUser, resource.R_class"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	boolean check = true;
	
	if(id.equals("")){
		out.println("<script>");
		out.println("alert('아이디를 입력해주세요.');");
		out.println("history.back();");
		out.println("</script>");
		check = false;
	}
	
	if(check && pw.equals("")){
		out.println("<script>");
		out.println("alert('비밀번호를 입력해주세요.');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	CheckUser check_user = new CheckUser();
	R_class R = new R_class();
	
	if(check){
		
		String type;
		if(check_user.Exist(id, pw)){
			type = (String)R.get("user_type");
			if(type.equals("U")){
				out.println("<script>");
				out.println("alert('로그인 성공!');");
				out.println("location.href='../view/UserMain.jsp';");
				out.println("</script>");
			}
			else if(type.equals("M")){
				out.println("<script>");
				out.println("alert('로그인 성공!');");
				out.println("location.href='../view/ManagerMain.jsp';");
				out.println("</script>");
			}
			
			
		}else{
			out.println("<script>");
			out.println("alert('계정 정보가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
	
	
%>

</body>
</html>