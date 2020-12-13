<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.EpisodeDAO"%>
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
		String season_number = request.getParameter("season_number");
		String episode_number = request.getParameter("episode_number");
		
		EpisodeDAO dao = new EpisodeDAO();
		
		if(dao.dropEpisode(Integer.parseInt(movie_id),Integer.parseInt(season_number),Integer.parseInt(episode_number))){
			out.println("<script>");
			out.println("alert('Episode 삭제 성공.');");
			out.println("location.href='../view_man/DeleteEpisode.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('Episode 삭제 실패.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	
	%>
</body>
</html>