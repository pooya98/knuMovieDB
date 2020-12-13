<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MovieDAO"%>
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
		
		MovieDAO dao = new MovieDAO();
		
		if(dao.dropMovie(Integer.parseInt(movie_id))){
			out.println("<script>");
			out.println("alert('Movie 삭제 성공.');");
			out.println("location.href='../view_man/DeleteMovie.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('Movie 삭제 실패.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	
	%>
</body>
</html>