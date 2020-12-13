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
	<tr><td><a href="../view_man/Mypage.jsp">마이페이지 홈</a></td>
	<td><a href="../view_man/ShowMyInfo.jsp">회원정보 조회</a></td>
    <td><a href="../view_man/ModifyMyInfo.jsp">회원정보 수정</a></td>
	<td><a href="../view_man/ModifyPassword.jsp">비밀번호 수정</a></td>
	<td><a href="../view_man/DropAccount.jsp">회원탈퇴</a></td>
</table>

<%
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = dao.getUserInfo(session.getAttribute("username").toString());
	out.println("<br>[현재 사용자 고유번호 : "+dto.getId()+"]<br><br>");
	out.println("[현재 사용자 id : "+dto.getUsername()+"]<br><br>");
	
	out.println("[현재 사용자 이름 : "+dto.getName()+"]");
	out.println("<form method=\"post\" action=\"../func/ModifyName.jsp\">");
	out.println(" ---> 변경할 사용자 이름* : <input type=\"text\" class=\"form-control\" placeholder=\"변경할 이름\" name=\"name\" maxlength=\"20\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 연락처 : "+dto.getContact()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyContact.jsp\">");
	out.println(" ---> 변경할 사용자 연락처* : <input type=\"text\" class=\"form-control\" placeholder=\"변경할 연락처(xxx-xxxx-xxxx)\" name=\"contact\" maxlength=\"13\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 주소 : "+dto.getAddress()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyAddress.jsp\">");
	out.println(" ---> 변경할 사용자 주소 : <input type=\"text\" class=\"form-control\" placeholder=\"변경할 주소\" name=\"address\" maxlength=\"100\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 성별 : "+dto.getSex()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifySex.jsp\">");
	out.println(" ---> 변경할 사용자 성별 : SEX&nbsp;&nbsp;<select name='sex'><option value='No'>성별</option><option value='M'>남자</option><option value='F'>여자</option><option value='No'>선택안함</option></select>");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 생년 월일 : "+dto.getBirth()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyBirth.jsp\">");
	out.println(" ---> 변경할 사용자 생년월일 : <input type=\"text\" class=\"form-control\" placeholder=\"변경할 생년월일(yyyy-mm-dd)\" name=\"birth\" maxlength=\"10\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 직업 : "+dto.getJob()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyJob.jsp\">");
	out.println(" ---> 변경할 사용자 직업 : <input type=\"text\" class=\"form-control\" placeholder=\"변경할 직업정보\" name=\"job\" maxlength=\"20\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"변경하기\"></form><br><br>");
	out.println("[현재 사용자 멤버쉽 : "+dto.getMembership()+"]<br>");

%>	
	
</body>
</html>