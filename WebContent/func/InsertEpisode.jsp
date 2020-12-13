<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="model.EpisodeDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String movie_id = session.getAttribute("selected_movie_id").toString();
	String season_number = request.getParameter("season_number");
	String episode_number = request.getParameter("episode_number");
	String episode_title = request.getParameter("episode_title");
	String episode_runtime = request.getParameter("episode_runtime");
	
	
	if(season_number.replaceAll(" ","").equals("") || episode_number.replaceAll(" ","").equals("") || episode_title.replaceAll(" ","").equals("") || episode_runtime.replaceAll(" ","").equals("")){
		out.println("<script>");
		out.println("alert('필수 정보가 입력되지 않았습니다.');");
		out.println("history.back();");
		out.println("</script>");
	}else{
		EpisodeDAO dao = new EpisodeDAO();
		
		if(dao.Exist(movie_id, season_number, episode_number)){
			out.println("<script>");
			out.println("alert('이미 해당 시즌 번호, 에피소드 번호의 에피소드가 존재합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else{
		
			if(dao.insert_episode(Integer.parseInt(movie_id), Integer.parseInt(season_number), Integer.parseInt(episode_number), episode_title, Integer.parseInt(episode_runtime))){
				out.println("<script>");
				out.println("alert('Episode 등록에 성공 했습니다.');");
				out.println("location.href='../view_man/InsertContents.jsp';");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('에피소드 등록이 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
	}
%>
</body>
</html>