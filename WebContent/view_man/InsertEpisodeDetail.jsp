<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class, java.util.List, model.EpisodeDAO, model.MovieDAO, model.MovieDTO, model.EpisodeDTO"%>
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
	
<br><br>
<table border=\"1\">
	<td><a href="../view_man/InsertContents.jsp">���� ��� Ȩ</a></td>
    <td><a href="../view_man/InsertMovie.jsp">Movie ���</a></td>
	<td><a href="../view_man/InsertEpisode.jsp">Episode ���</a></td>
	<td><a href="../view_man/InsertVersion.jsp">Version ���</a></td>
</table>

<%
	String movie_id = request.getParameter("movie_id");

	MovieDAO dao = new MovieDAO();
	MovieDTO dto = dao.detailInfo(Integer.parseInt(movie_id));
	
	out.println("<h3>'"+dto.getTitle()+"' ����ȸ</h3>");
	
	out.println("���� :"+dto.getTitle()+"<br>");
	out.println("���� :"+dto.getType()+"<br>");
	out.println("�帣 :"+dto.getGenre()+"<br>");
	out.println("������ :"+dto.getStart_date().substring(0,10)+"<br>");
	out.println("����ð� :"+dto.getRuntime()+"<br>");
	out.println("���� :"+dto.getRating()+"<br>");
	out.println("�� �� : "+dto.getRateUser()+"<br><br>");
	
%>

<%
	out.println("<h4>'"+dto.getTitle()+"' "+"���Ǽҵ� ���</h4>");
	EpisodeDAO dao_E = new EpisodeDAO();
	List<EpisodeDTO> list = dao_E.get_list(Integer.parseInt(movie_id));
	
	out.println("<table border=\"1\">");
	out.println("<th>�ø��� ����</th>");
	out.println("<th>���� ��ȣ</th>");
	out.println("<th>���Ǽҵ� ��ȣ</th>");
	out.println("<th>���Ǽҵ� ����</th>");
	out.println("<th>���Ǽҵ� �󿵽ð�</th>");
	
	int count=0;
	
	for (EpisodeDTO dto2 : list) {
			count++;
			out.println("<tr>");
			out.println("<td>"+dto2.getMovie_title()+"</td>");
			out.println("<td>"+dto2.getSeason()+"</td>");
			out.println("<td>"+dto2.getEpisodeNum()+"</td>");
			out.println("<td>"+dto2.getEpisodeTitle()+"</td>");
			out.println("<td>"+dto2.getEpisodeRuntime()+"</td>");
			out.println("</tr>");
	}
	
	if(count == 0) {
		out.println("��ϵ� ���Ǽҵ� ����.");
	}
	
	out.println("</table><br><br>");
	
	out.println("<h4>���Ǽҵ� �߰��ϱ�</h4>");
	
	session.setAttribute("selected_movie_id", movie_id);
	
%>

<form method="post" action="../func/InsertEpisode.jsp">
     ���� ��ȣ*<input type="number" class="form-control" placeholder="�����ȣ" name="season_number" maxlength="5"><br>
     ���Ǽҵ� ��ȣ*<input type="number" class="form-control" placeholder="���Ǽҵ� ��ȣ" name="episode_number" maxlength="5"><br>
     ���Ǽҵ� ����*<input type="text" class="form-control" placeholder="���Ǽҵ� ����" name="episode_title" maxlength="50"><br>
     ���Ǽҵ� ����ð�*<input type="number" class="form-control" placeholder="���Ǽҵ� ����ð�" name="episode_runtime" maxlength="5"><br>
<input type="submit" class="btn btn-primary form-control" value="���Ǽҵ� �߰��ϱ�"><br><br></form>

<button onclick="history.back()">�ڷΰ���</button>

</form>
</body>
</html>