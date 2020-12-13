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
	<td><a href="../view_man/DeleteContents.jsp">���� ���� ���� Ȩ</a></td>
    <td><a href="../view_man/DeleteMovie.jsp">Movie ����</a></td>
	<td><a href="../view_man/DeleteEpisode.jsp">Episode ����</a></td>
	<td><a href="../view_man/DeleteVersion.jsp">Version ����</a></td>
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
	out.println("<h3>������ ���� ������ '����'��ư�� ��������</h3><button onclick=\"history.back()\">�ڷΰ���</button>");

	VersionDAO dao_V = new VersionDAO();
	List<VersionDTO> list = dao_V.get_list(Integer.parseInt(movie_id));
	
	out.println("<table border=\"1\">");
	out.println("<th>���� ����</th>");
	out.println("<th>����</th>");
	out.println("<th>���� ����</th>");
	out.println("<th>original ����</th>");
	out.println("<th>����</th>");
	
	int count=0;
	
	for (VersionDTO dto2 : list) {
			count++;
			out.println("<tr>");
			out.println("<td>"+dto2.getMovie_title()+"</td>");
			out.println("<td>"+dto2.getNationality_short()+"</td>");
			out.println("<td>"+dto2.getVersion_title()+"</td>");
			out.println("<td>"+dto2.getIs_original()+"</td>");
			out.println("<td>"+"<a href=\"../func/DeleteVersion.jsp?movie_id="+dto.getId()+"&version="+dto2.getNationality_short()+"\">"+"����"+"</a></td>");
			out.println("</tr>");
	}
	
	if(count == 0) {
		out.println("��ϵ� ���� ����.");
	}
	
	out.println("</table><br><br>");
	
	
%>

</body>
</html>