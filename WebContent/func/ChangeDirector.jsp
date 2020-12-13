<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.DirectorDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		boolean was_null = (boolean)session.getAttribute("was_null");
		String movie_id = request.getParameter("movie_id");
		String director_id = request.getParameter("director_id");
		
		DirectorDAO dao = new DirectorDAO();
		
		if(dao.update_produce(Integer.parseInt(movie_id), Integer.parseInt(director_id), was_null)){
			out.println("<script>");
			out.println("alert('영상물 감독 정보 변경 성공.');");
			out.println("location.href='../view_man/ModifyMovieDirectorInfo.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('영상물 감독 정보 변경 실패.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	
	%>
</body>
</html>