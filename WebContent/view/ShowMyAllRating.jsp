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
	RatingDAO dao = new RatingDAO();

	List<RatingDTO> list = dao.myList(session.getAttribute("username").toString());

	int count=0;

	out.println("<h3>나의 평가 리스트</h3>");
	


	out.println("<table border=\"1\">");
	out.println("<th>영상물 고유번호</th>");
	out.println("<th>제목</th>");
	out.println("<th>종류</th>");
	out.println("<th>장르</th>");
	out.println("<th>상영시간</th>");
	out.println("<th>개봉일</th>");
	out.println("<th>평점</th>");
	out.println("<th>나의 평점</th>");
	
	
	for (RatingDTO dto : list) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto.getMovie_id()+"</td>");
		out.println("<td>"+"<a href=\"../view/ShowRatingDetail.jsp?movie_id="+dto.getMovie_id()+"\">"+dto.getMovie_title()+"</a></td>");
		out.println("<td>"+dto.getMovie_type()+"</td>");
		out.println("<td>"+dto.getMovie_genre()+"</td>");
		out.println("<td>"+dto.getMovie_runtime()+"</td>");
		out.println("<td>"+dto.getMovie_start_date().substring(0, 10)+"</td>");
		out.println("<td>"+dto.getMovie_rating()+"</td>");
		out.println("<td>"+dto.getMy_rating()+"</td>");
		out.println("</tr>");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	
	if(count == 0) {
		out.println("평가 정보가 존재하지 않습니다.");
	}
	
	System.out.println("</table>");
%>
	
	
	
	
</body>
</html>