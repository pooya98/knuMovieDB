<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class, java.util.List, model.VersionDAO, model.MovieDAO, model.MovieDTO, model.VersionDTO"%>
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
	<td><a href="../view_man/DeleteContents.jsp">영상물 정보 삭제 홈</a></td>
    <td><a href="../view_man/DeleteMovie.jsp">Movie 삭제</a></td>
	<td><a href="../view_man/DeleteEpisode.jsp">Episode 삭제</a></td>
	<td><a href="../view_man/DeleteVersion.jsp">Version 삭제</a></td>
</table>


<%
	String movie_id = request.getParameter("movie_id");

	MovieDAO dao = new MovieDAO();
	MovieDTO dto = dao.detailInfo(Integer.parseInt(movie_id));
	
	out.println("<h3>'"+dto.getTitle()+"' 상세조회</h3>");
	
	out.println("제목 :"+dto.getTitle()+"<br>");
	out.println("종류 :"+dto.getType()+"<br>");
	out.println("장르 :"+dto.getGenre()+"<br>");
	out.println("개봉일 :"+dto.getStart_date().substring(0,10)+"<br>");
	out.println("재생시간 :"+dto.getRuntime()+"<br>");
	out.println("평점 :"+dto.getRating()+"<br>");
	out.println("평가 수 : "+dto.getRateUser()+"<br><br>");
	
%>

<%
	out.println("<h3>삭제할 행의 오른쪽 '삭제'버튼을 누르세요</h3><button onclick=\"history.back()\">뒤로가기</button>");

	VersionDAO dao_V = new VersionDAO();
	List<VersionDTO> list = dao_V.get_list(Integer.parseInt(movie_id));
	
	out.println("<table border=\"1\">");
	out.println("<th>영상물 제목</th>");
	out.println("<th>버전</th>");
	out.println("<th>버전 제목</th>");
	out.println("<th>original 유무</th>");
	out.println("<th>삭제</th>");
	
	int count=0;
	
	for (VersionDTO dto2 : list) {
			count++;
			out.println("<tr>");
			out.println("<td>"+dto2.getMovie_title()+"</td>");
			out.println("<td>"+dto2.getNationality_short()+"</td>");
			out.println("<td>"+dto2.getVersion_title()+"</td>");
			out.println("<td>"+dto2.getIs_original()+"</td>");
			out.println("<td>"+"<a href=\"../func/DeleteVersion.jsp?movie_id="+dto.getId()+"&version="+dto2.getNationality_short()+"\">"+"삭제"+"</a></td>");
			out.println("</tr>");
	}
	
	if(count == 0) {
		out.println("등록된 버전 없음.");
	}
	
	out.println("</table><br><br>");
	
	
%>

</body>
</html>