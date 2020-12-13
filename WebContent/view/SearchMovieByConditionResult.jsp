<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.MovieDAO, model.MovieDTO, java.util.List"%>
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
	
<br><br>

<%
	String type = request.getParameter("type").toString();
	String genre = request.getParameter("genre").toString();
	String version = request.getParameter("version").toString();
	
	MovieDAO dao = new MovieDAO();
	List<MovieDTO> list;
	
	list = dao.list_for_condition_search(Integer.parseInt(session.getAttribute("id").toString()), type, genre, version);
	
	out.println("검색된 영상물 리스트");
	out.println("<button onclick=\"history.back()\">다시 검색하기</button>");
	out.println("<br>");

	out.println("<table border=\"1\">");
	out.println("<th>고유번호</th>");
	out.println("<th>제목</th>");
	out.println("<th>종류</th>");
	out.println("<th>장르</th>");
	out.println("<th>상영시간</th>");
	out.println("<th>개봉일</th>");
	out.println("<th>평점</th>");
	out.println("<th>버전</th>");
	
	int count=0;
	
	for (MovieDTO dto : list) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto.getId()+"</td>");
		out.println("<td>"+"<a href=\"../view/SearchMovieByConditionResultDetail.jsp?id="+dto.getId()+"\">"+dto.getTitle()+"</a></td>");
		out.println("<td>"+dto.getType()+"</td>");
		out.println("<td>"+dto.getGenre()+"</td>");
		out.println("<td>"+dto.getRuntime()+"</td>");
		out.println("<td>"+dto.getStart_date().substring(0, 10)+"</td>");
		out.println("<td>"+dto.getRating()+"</td>");
		out.println("<td>"+dto.getVersion()+"</td>");
		out.println("</tr>");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	
	if(count == 0) {
		out.println("검색된 영상물 없음.");
	}
	
	System.out.println("</table>");	
%>

	
	
</body>
</html>