<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.RatingDTO, model.RatingDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB-SignUp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	String point = request.getParameter("point");
	String comments = request.getParameter("comment");

	boolean check = false;

	if(point.equals("0") || point.equals("1") ||point.equals("2") ||point.equals("3") ||point.equals("4") ||point.equals("5") ||point.equals("6") ||point.equals("7") ||point.equals("8") || point.equals("9") || point.equals("10")){
		check = true;
	}else{
		out.println("<script>");
		out.println("alert('평점 입력이 잘못됬습니다(1~10).');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	if(check){
		if(comments.equals("")){
			out.println("<script>");
			out.println("alert('코멘트를 입력해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			RatingDAO dao = new RatingDAO();
			
			if(dao.insertRate(Integer.parseInt(session.getAttribute("id").toString()), Integer.parseInt(session.getAttribute("selected_movie_id").toString()), Integer.parseInt(point), comments)){
				out.println("<script>");
				out.println("alert('평가 정보 저장 성공.');");
				out.println("location.href='../view/SearchMovieByTitle.jsp';");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('평가 저장 실패.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
	}
	%>
</body>
</html>