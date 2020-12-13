<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.RatingDAO, model.RatingDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB</title>
</head>
<body>
<h1>knuMovieDB</h1>

<%
	String username = session.getAttribute("username").toString();

	out.println("<h3>"+username+" 님, 환영합니다."+"</h3>");
%>
<table border=\"1\">
	<tr><td><a href="../view/UserMain.jsp">홈</a></td>
    <td><a href="../view/ShowAllMovie.jsp">전체 영상물 조회</a></td>
	<td><a href="../view/SearchMovieByTitle.jsp">제목으로 영상물 조회</a></td>
	<td><a href="../view/SearchMovieByCondition.jsp">영상물 조건 검색</a></td>
	<td><a href="../view/ShowMyAllRating.jsp">나의 평가내역 조회</a></td>
	<td><a href="../view/Mypage.jsp">마이페이지</a></td>
	<td><a href="../func/LogOut.jsp">로그아웃</a></td></tr>
</table>
	
<%
	int movie_id = Integer.parseInt(request.getParameter("movie_id").toString());

	RatingDAO dao = new RatingDAO();

	RatingDTO dto = new RatingDTO();
	
	dto = dao.Rating_info(session.getAttribute("username").toString(), movie_id);

	out.println("<h3>나의 평가 상세조회</h3>");
	
	out.println("제목 :"+dto.getMovie_title()+"<br>");
	out.println("종류 :"+dto.getMovie_type()+"<br>");
	out.println("장르 :"+dto.getMovie_genre()+"<br>");
	out.println("개봉일 :"+dto.getMovie_start_date().substring(0,10)+"<br>");
	out.println("재생시간 :"+dto.getMovie_runtime()+"<br>");
	out.println("평점 :"+dto.getMovie_rating()+"<br><br>");
	
	
	out.println("나의 평점 :"+dto.getMy_rating()+"<br>");
	out.println("나의 후기 :"+dto.getMy_comments()+"<br><br>");
	
	
%>
<button onclick="history.back()">확인</button>
	
	
	
</body>
</html>