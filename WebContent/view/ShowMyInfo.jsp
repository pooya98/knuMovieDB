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
	<td>회원정보 조회</td>
    <td><a href="../view/ModifyMyInfo.jsp">회원정보 수정</a></td>
	<td><a href="../view/ModifyPassword.jsp">비밀번호 수정</a></td>
	<td><a href="../view/DropAccount.jsp">회원탈퇴</a></td>
</table>

<%
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = dao.getUserInfo(session.getAttribute("username").toString());
	out.println("<br>사용자 고유번호 : "+dto.getId()+"<br>");
	out.println("사용자 id : "+dto.getUsername()+"<br>");
	out.println("사용자 이름 : "+dto.getName()+"<br>");
	out.println("사용자 연락처 : "+dto.getContact()+"<br>");
	out.println("사용자 주소 : "+dto.getAddress()+"<br>");
	out.println("사용자 성별 : "+dto.getSex()+"<br>");
	out.println("사용자 생년 월일 : "+dto.getBirth()+"<br>");
	out.println("사용자 직업 : "+dto.getJob()+"<br>");
	out.println("사용자 멤버쉽 : "+dto.getMembership()+"<br>");

%>	
	
</body>
</html>