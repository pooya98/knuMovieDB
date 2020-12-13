<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.VersionDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String movie_id = request.getParameter("movie_id");
		String version = request.getParameter("version");
		
		VersionDAO dao = new VersionDAO();
		
		if(dao.dropVersion(Integer.parseInt(movie_id),version)){
			out.println("<script>");
			out.println("alert('Version 삭제 성공.');");
			out.println("location.href='../view_man/DeleteVersion.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('Version 삭제 실패.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	
	%>
</body>
</html>