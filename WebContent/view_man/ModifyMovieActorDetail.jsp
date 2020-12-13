<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.DirectorDAO,model.DirectorDTO, java.util.List, model.VersionDAO, model.MovieDAO, model.MovieDTO, model.VersionDTO, model.ActorDAO, model.ActorDTO"%>
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
	
	DirectorDAO dao_D = new DirectorDAO();
	DirectorDTO dto_D = dao_D.getMovieDirector(Integer.parseInt(movie_id));
	
	if(dto_D.getName() == null){
		out.println("감독  : "+"정보 없음"+"<br><br>");
	}else{
		out.println("감독  : "+dto_D.getName()+"");
	}
	
%>
<button onclick="history.back()">뒤로가기</button>
<%
	out.println("<h3>'"+dto.getTitle()+"'에 등록된 배우 목록</h3>");

	ActorDAO dao_A = new ActorDAO();
	List<ActorDTO> list = dao_A.get_list_this_movie(Integer.parseInt(movie_id));
	
	out.println("<table border=\"1\">");
	out.println("<th>고유 번호</th>");
	out.println("<th>이름</th>");
	out.println("<th>생년월일</th>");
	out.println("<th>성별</th>");
	out.println("<th>이 영화에서 삭제</th>");
	
	int count=0;
	
	for (ActorDTO dto2 : list) {
			count++;
			out.println("<tr>");
			out.println("<td>"+dto2.getId()+"</td>");
			out.println("<td>"+dto2.getName()+"</td>");
			out.println("<td>"+dto2.getBirth().substring(0,10)+"</td>");
			out.println("<td>"+dto2.getSex()+"</td>");
			out.println("<td>"+"<a href=\"../func/DeleteMovieActor.jsp?movie_id="+dto.getId()+"&actor_id="+dto2.getId()+"\">"+"이 영화에서 삭제"+"</a></td>");
			out.println("</tr>");
	}
	
	if(count == 0) {
		out.println("등록된 배우 없음.");
	}
	
	out.println("</table><br><br>");
	
	
	list = dao_A.get_list_not_exist(Integer.parseInt(movie_id));
	
	out.println("<h3>'"+dto.getTitle()+"'에 추가 가능한 배우 목록</h3>");
	out.println("<table border=\"1\">");
	out.println("<th>고유 번호</th>");
	out.println("<th>이름</th>");
	out.println("<th>생년월일</th>");
	out.println("<th>성별</th>");
	out.println("<th>이 영화에 추가</th>");
	
	for (ActorDTO dto2 : list) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto2.getId()+"</td>");
		out.println("<td>"+dto2.getName()+"</td>");
		out.println("<td>"+dto2.getBirth().substring(0,10)+"</td>");
		out.println("<td>"+dto2.getSex()+"</td>");
		out.println("<td>"+"<a href=\"../func/InsertMovieActor.jsp?movie_id="+dto.getId()+"&actor_id="+dto2.getId()+"\">"+"이 영화에 추가"+"</a></td>");
		out.println("</tr>");
		
	}
		if(count == 0) {
			out.println("등록된 배우 없음.");
		}
		
		out.println("</table><br><br>");
	
%>
</body>
</html>