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

	out.println("<h3>"+username+" �����ڴ�, ȯ���մϴ�."+"</h3>");
%>
<table border=\"1\">
	<tr><td>Ȩ</td>
    <td><a href="../view_man/ShowAllMovie.jsp">��ü ���� ��ȸ</a></td>
	<td><a href="../view_man/SearchMovieByTitle.jsp">�������� ���� ��ȸ</a></td>
	<td><a href="../view_man/SearchMovieByCondition.jsp">���� ���� �˻�</a></td>
	<td><a href="../view_man/ShowAllRating.jsp">��ü �򰡳��� ��ȸ</a></td>
	<td><a href="../view_man/InsertContents.jsp">���� ���� ���</a></td>
	<td><a href="../view_man/DeleteContents.jsp">���� ���� ����</a></td>
	<td><a href="../view_man/ModifyMovieDirectorInfo.jsp">���� ���� ���� ����</a></td>
	<td><a href="../view_man/ModifyMovieActorInfo.jsp">���� ��� ���� ����</a></td>
	<td><a href="../view_man/Mypage.jsp">����������</a></td>
	<td><a href="../func/LogOut.jsp">�α׾ƿ�</a></td></tr>
	</table>
	
<%
	MovieDAO dao = new MovieDAO();

	MovieDTO dto;
	
	dto = dao.detailInfo(Integer.parseInt(request.getParameter("id")));

	out.println("<h3>'"+dto.getTitle()+"' ����ȸ</h3>");
	
	out.println("<table border=\"1\">");
	
	out.println("<tr>");
	out.println("<td>����</td>");
	out.println("<td>"+dto.getTitle()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>����</td>");
	out.println("<td>"+dto.getType()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>�帣</td>");
	out.println("<td>"+dto.getGenre()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>������</td>");
	out.println("<td>"+dto.getStart_date().substring(0,10)+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>����ð�</td>");
	out.println("<td>"+dto.getRuntime()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>����</td>");
	out.println("<td>"+dto.getRating()+"</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>�� ��</td>");
	out.println("<td>"+dto.getRateUser()+"</td>");
	out.println("</tr></table>");
	
	
	out.println("<h3>���� ����</h3>");
	
	DirectorDAO dao_D = new DirectorDAO();
	DirectorDTO dto_D = dao_D.getMovieDirector(dto.getId());
	
	if(dto_D.getName() != null){
	out.println("<table border=\"1\">");
	out.println("<tr>");
	out.println("<td>������</td>");
	out.println("<td>���� �������</td>");
	out.println("<td>���� ����</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>"+dto_D.getName()+"</td>");
	out.println("<td>"+dto_D.getBirth().substring(0,10)+"</td>");
	out.println("<td>"+dto_D.getSex()+"</td>");
	out.println("</tr></table>");
	}else{
		out.println("���� ���� ����");
	}

	
	out.println("<h3>��� ����</h3>");
	
	ActorDAO dao_A = new ActorDAO();
	List<ActorDTO> actor_list = dao_A.get_list_this_movie(dto.getId());
	
	if(actor_list != null){
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>����</td>");
		out.println("<td>��� �������</td>");
		out.println("<td>��� ����</td>");
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
		out.println("��� ���� ����");
	}
	
	out.println("<h3>���� ����</h3>");
	
	VersionDAO dao_V = new VersionDAO();
	List<VersionDTO> version_list = dao_V.get_list(dto.getId());
	
	if(version_list != null){
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>���� ����</td>");
		out.println("<td>����</td>");
		out.println("<td>���� ����</td>");
		out.println("<td>original ����</td>");
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
		out.println("���� ���� ����");
	}

	
	if(dto.getType().equals("TV Series")){
		out.println("<h3>���Ǽҵ� ����</h3>");
		EpisodeDAO dao_E = new EpisodeDAO();
		List<EpisodeDTO> episode_list = dao_E.get_list(dto.getId());
		
		if(episode_list != null){
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<td>�ø��� ����</td>");
			out.println("<td>���� ��ȣ</td>");
			out.println("<td>���Ǽҵ� ��ȣ</td>");
			out.println("<td>���Ǽҵ� ����</td>");
			out.println("<td>���Ǽҵ� ����ð�</td>");
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
			out.println("���Ǽҵ� ���� ����");
		}
	}
	
%>
<br>
 <button onclick="history.back()">Ȯ��</button>
 <br><br>
</body>
</html>