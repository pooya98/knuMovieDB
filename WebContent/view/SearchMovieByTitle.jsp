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
	<td>제목으로 영상물 조회</td>
	<td><a href="../view/SearchMovieByCondition">영상물 조건 검색</a></td>
	<td><a href="../view/ShowMyAllRating">나의 평가내역 조회</a></td>
	<td><a href="../view/Mypage.jsp">마이페이지</a></td>
	<td><a href="../func/LogOut.jsp">로그아웃</a></td></tr>
	</table>
	
<br><br>
<form method="post" action="../view/SearchMovieByTitleResult.jsp">
     <input type="text" class="form-control" placeholder="검색할 영화제목" name="title" maxlength="50">
<input type="submit" class="btn btn-primary form-control" value="검색">
</form>
	
	
	
	
</body>
</html>