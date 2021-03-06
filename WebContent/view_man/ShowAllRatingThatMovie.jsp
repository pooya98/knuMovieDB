<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.RatingDAO, model.RatingDTO, model.MovieDAO, model.MovieDTO, java.util.List"%>
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
	out.println("평가 수 : "+dto.getRateUser()+"<br>");
	
	
	RatingDAO dao_R = new RatingDAO();
	List<RatingDTO> RatingList = dao_R.ListThatMovie(request.getParameter("id").toString());
	
	int count =0;
	
	out.println("<table border=\"1\">");
	out.println("<th>ID</th>");
	out.println("<th>평점</th>");
	out.println("<th>코멘트</th>");
	
	for (RatingDTO dto2 : RatingList) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto2.getAccount_username()+"</td>");
		out.println("<td>"+dto2.getMy_rating()+"</td>");
		out.println("<td>"+dto2.getMy_comments()+"</td>");
		out.println("</tr>");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	
	if(count == 0) {
		out.println("평가 없음.");
	}
	out.println("</table>");
	
	
	
%>
<br>
 <button onclick="history.back()">확인</button>
</body>
</html>