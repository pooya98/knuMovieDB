<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ActorDAO"%>
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
		String actor_id = request.getParameter("actor_id");
		
		ActorDAO dao = new ActorDAO();
		
		if(dao.insert_participate(Integer.parseInt(movie_id), Integer.parseInt(actor_id))){
			out.println("<script>");
			out.println("alert('영상물 배우 정보 추가 성공.');");
			out.println("location.href='../view_man/ModifyMovieActorInfo.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('영상물 배우 정보 추가 실패.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	
	%>
</body>
</html>