<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class, model.MovieDAO, model.MovieDTO, java.util.List"%>
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
	<td>영상물 조건 검색</td>
	<td><a href="../view/ShowMyAllRating.jsp">나의 평가내역 조회</a></td>
	<td><a href="../view/Mypage.jsp">마이페이지</a></td>
	<td><a href="../func/LogOut.jsp">로그아웃</a></td></tr>
	</table>
	
<%
	MovieDAO dao = new MovieDAO();

	MovieDTO dto;
	
	dto = dao.detailInfo(Integer.parseInt(request.getParameter("id")));

	out.println("<h3>'"+dto.getTitle()+"' 상세조회</h3>");
	
	out.println("제목 :"+dto.getTitle()+"<br>");
	out.println("종류 :"+dto.getType()+"<br>");
	out.println("장르 :"+dto.getGenre()+"<br>");
	out.println("개봉일 :"+dto.getStart_date().substring(0,10)+"<br>");
	out.println("재생시간 :"+dto.getRuntime()+"<br>");
	out.println("평점 :"+dto.getRating()+"<br>");
	out.println("평가 수 : "+dto.getRateUser()+"<br><br>");
	
	session.setAttribute("selected_movie_id", Integer.parseInt(request.getParameter("id")));
	
	
	out.println("<form method=\"post\" action=\"../func/InsertRating_Condition.jsp\">");
    out.println("<input type=\"text\" class=\"form-control\" placeholder=\"평점(1~10점)\" name=\"point\" maxlength=\"2\"><br>");
    out.println("<input type=\"text\" class=\"form-control\" placeholder=\"코멘트\" style=\"width:300px;height:200px;\" name=\"comment\" maxlength=\"100\"><br>");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"평가하기\"></form>");
%>


 <button onclick="history.back()">뒤로가기</button>
</body>
</html>