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
	String title = request.getParameter("title");
	if (title.equals("")) {
		out.println("<script>");
		out.println("alert('제목을 입력해주세요.');");
		out.println("history.back();");
		out.println("</script>");

	}else{
		MovieDAO dao = new MovieDAO();

		List<MovieDTO> list = dao.list_for_title_search(Integer.parseInt(session.getAttribute("id").toString()),title);

		int count=0;
		out.println("<br><br>");
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
		
		for (MovieDTO dto : list) {
			count++;
			out.println("<tr>");
			out.println("<a href=\"../view/UserMain.jsp\">");
			out.println("<td>"+dto.getId()+"</td>");
			out.println("<td>"+"<a href=\"../view_man/SearchMovieByTitleResultDetail.jsp?id="+dto.getId()+"\">"+dto.getTitle()+"</a></td>");
			out.println("<td>"+dto.getType()+"</td>");
			out.println("<td>"+dto.getGenre()+"</td>");
			out.println("<td>"+dto.getRuntime()+"</td>");
			out.println("<td>"+dto.getStart_date().substring(0, 10)+"</td>");
			out.println("<td>"+dto.getRating()+"</td>");
			out.println("</a>");
			out.println("</tr>");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		if(count == 0) {
			out.println("검색된 영상물 없음.");
		}
		
		System.out.println("</table>");	
	}
%>
	
	
	
	
</body>
</html>