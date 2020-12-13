<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.AccountDAO, model.AccountDTO"%>
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
	<td>마이페이지</td>
	<td><a href="../func/LogOut.jsp">로그아웃</a></td></tr>
</table>
	
	<br><br>
<table border=\"1\">
	<tr><td><a href="../view/Mypage.jsp">마이페이지 홈</a></td>
	<td><a href="../view/ShowMyInfo.jsp">회원정보 조회</a></td>
    <td><a href="../view/ModifyMyInfo.jsp">회원정보 수정</a></td>
	<td>비밀번호 수정</td>
	<td><a href="../view/DropAccount.jsp">회원탈퇴</a></td>
</table>
<br><br>
<form method="post" action="../func/ModifyPassword.jsp">
	
     현재 비밀번호:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="현재 비밀번호" name="cur_password" maxlength="20"><br>
     새로운 비밀번호:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="새로운 비밀번호" name="new_password" maxlength="20"><br>
     새로운 비밀번호 확인:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="새로운 비밀번호 확인" name="new_password_check" maxlength="20"><br>
     
     <br>
     <input type="submit" class="btn btn-primary form-control" value="변경하기">
</form>
	
</body>
</html>