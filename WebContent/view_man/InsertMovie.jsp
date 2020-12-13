<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovie</title>
</head>
<body>
<h1>knuMovieDB</h1>

<%
	String username = session.getAttribute("username").toString();

	out.println("<h3>"+username+" 관리자님, 환영합니다."+"</h3>");
%>
<table border=\"1\">
	<tr><td>홈</td>
    <td><a href="../view_man/ShowAllMovie.jsp">전체 영상물 조회</a></td>
	<td><a href="../view_man/SearchMovieByTitle.jsp">제목으로 영상물 조회</a></td>
	<td><a href="../view_man/SearchMovieByCondition.jsp">영상물 조건 검색</a></td>
	<td><a href="../view_man/ShowAllRating.jsp">전체 평가내역 조회</a></td>
	<td><a href="../view_man/InsertContents.jsp">영상물 정보 등록</a></td>
	<td><a href="../view_man/DeleteContents.jsp">영상물 정보 삭제</a></td>
	<td><a href="../view_man/ModifyMovieDirectorInfo.jsp">영상물 감독 정보 변경</a></td>
	<td><a href="../view_man/ModifyMovieActorInfo.jsp">영상물 배우 정보 변경</a></td>
	<td><a href="../view_man/Mypage.jsp">마이페이지</a></td>
	<td><a href="../func/LogOut.jsp">로그아웃</a></td></tr>
	</table>
	
<br><br>
<table border=\"1\">
	<td><a href="../view_man/InsertContents.jsp">영상물 등록 홈</a></td>
    <td><a href="../view_man/InsertMovie.jsp">Movie 등록</a></td>
	<td><a href="../view_man/InsertEpisode.jsp">Episode 등록</a></td>
	<td><a href="../view_man/InsertVersion.jsp">Version 등록</a></td>
</table>


<form method="post" action="../func/InsertMovie.jsp">
	<h3>* 표시는 꼭 입력해야되는 정보입니다.</h3>
     영상물 제목*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="영상물 제목" name="title" maxlength="50"><br>
     영상물 종류*&nbsp;&nbsp;<select name='type'><option value='Movie'>Movie</option><option value='TV Series'>TV Series</option><option value='KnuMovieDB Original'>KnuMovieDB Original</option></select><br>
     영상물 장르*&nbsp;&nbsp;<select name='genre'><option value='Action'>Action</option><option value='Comedy'>Comedy</option><option value='Romance'>Romance</option><option value='SF'>SF</option><option value='Honor'>Honor</option><option value='Fantasy'>Fantasy</option></select><br>
     영상물 재생시간*&nbsp;&nbsp;<input type="number" class="form-control" placeholder="영상물 재생시간(분)" name="runtime" maxlength="3"><br>
     영상물 개봉일*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="개봉일(yyyy-mm-dd)" name="start_date" maxlength="12"><br>
     영상물 original version*&nbsp;&nbsp;<select name='version'><option value='KR'>KR</option><option value='US'>US</option><option value='JP'>JP</option><option value='CN'>CN</option><option value='IN'>IN</option></select><br>
 
     <br>
     <input type="submit" class="btn btn-primary form-control" value="Movie 등록">
</form>


</body>
</html>