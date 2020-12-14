<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class, model.MovieDAO, model.MovieDTO, java.util.List"%>
<%@ page import="model.DirectorDAO, model.DirectorDTO, model.ActorDAO, model.ActorDTO"%>
<%@ page import="model.VersionDAO, model.VersionDTO, model.EpisodeDAO, model.EpisodeDTO"%>
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
	
	out.println("<table border=\"1\">");
	
	out.println("<tr>");
	out.println("<td>제목</td>");
	out.println("<td>"+dto.getTitle()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>종류</td>");
	out.println("<td>"+dto.getType()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>장르</td>");
	out.println("<td>"+dto.getGenre()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>개봉일</td>");
	out.println("<td>"+dto.getStart_date().substring(0,10)+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>재생시간</td>");
	out.println("<td>"+dto.getRuntime()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>평점</td>");
	out.println("<td>"+dto.getRating()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>평가 수</td>");
	out.println("<td>"+dto.getRateUser()+"</td>");
	out.println("</tr></table>");
	
	
	out.println("<h3>감독 정보</h3>");
	
	DirectorDAO dao_D = new DirectorDAO();
	DirectorDTO dto_D = dao_D.getMovieDirector(dto.getId());
	
	if(dto_D.getName() != null){
	out.println("<table border=\"1\">");
	out.println("<tr>");
	out.println("<td>감독명</td>");
	out.println("<td>감독 생년월일</td>");
	out.println("<td>감독 성별</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>"+dto_D.getName()+"</td>");
	out.println("<td>"+dto_D.getBirth().substring(0,10)+"</td>");
	out.println("<td>"+dto_D.getSex()+"</td>");
	out.println("</tr></table>");
	}else{
		out.println("감독 정보 없음");
	}

	
	out.println("<h3>배우 정보</h3>");
	
	ActorDAO dao_A = new ActorDAO();
	List<ActorDTO> actor_list = dao_A.get_list_this_movie(dto.getId());
	
	if(actor_list != null){
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>배우명</td>");
		out.println("<td>배우 생년월일</td>");
		out.println("<td>배우 성별</td>");
		out.println("</tr>");
		
		for(ActorDTO dto_A : actor_list){
			out.println("<tr>");
			out.println("<td>"+dto_A.getName()+"</td>");
			out.println("<td>"+dto_A.getBirth().substring(0,10)+"</td>");
			out.println("<td>"+dto_A.getSex()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}else{
		out.println("배우 정보 없음");
	}
	
	out.println("<h3>버전 정보</h3>");
	
	VersionDAO dao_V = new VersionDAO();
	List<VersionDTO> version_list = dao_V.get_list(dto.getId());
	
	if(version_list != null){
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>영상물 제목</td>");
		out.println("<td>버전</td>");
		out.println("<td>버전 제목</td>");
		out.println("<td>original 유무</td>");
		out.println("</tr>");
		
		for(VersionDTO dto_V : version_list){
			out.println("<tr>");
			out.println("<td>"+dto_V.getMovie_title()+"</td>");
			out.println("<td>"+dto_V.getNationality_short()+"</td>");
			out.println("<td>"+dto_V.getVersion_title()+"</td>");
			out.println("<td>"+dto_V.getIs_original()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}else{
		out.println("버전 정보 없음");
	}

	
	if(dto.getType().equals("TV Series")){
		out.println("<h3>에피소드 정보</h3>");
		EpisodeDAO dao_E = new EpisodeDAO();
		List<EpisodeDTO> episode_list = dao_E.get_list(dto.getId());
		
		if(episode_list != null){
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<td>시리즈 제목</td>");
			out.println("<td>시즌 번호</td>");
			out.println("<td>에피소드 번호</td>");
			out.println("<td>에피소드 제목</td>");
			out.println("<td>에피소드 재생시간</td>");
			out.println("</tr>");
			
			for(EpisodeDTO dto_E : episode_list){
				out.println("<tr>");
				out.println("<td>"+dto_E.getMovie_title()+"</td>");
				out.println("<td>"+dto_E.getSeason()+"</td>");
				out.println("<td>"+dto_E.getEpisodeNum()+"</td>");
				out.println("<td>"+dto_E.getEpisodeTitle()+"</td>");
				out.println("<td>"+dto_E.getEpisodeRuntime()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}else{
			out.println("에피소드 정보 없음");
		}
	}
	
%>
<br>
 <button onclick="history.back()">확인</button>
 <br><br>
</body>
</html>