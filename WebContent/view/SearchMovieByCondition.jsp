<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.GenreDTO, model.GenreDAO, model.NationalityDAO, model.NationalityDTO, java.util.List"%>
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

	out.println("<h3>"+username+" ��, ȯ���մϴ�."+"</h3>");
%>
<table border=\"1\">
	<tr><td><a href="../view/UserMain.jsp">Ȩ</a></td>
    <td><a href="../view/ShowAllMovie.jsp">��ü ���� ��ȸ</a></td>
	<td><a href="../view/SearchMovieByTitle.jsp">�������� ���� ��ȸ</a></td>
	<td><a href="../view/SearchMovieByCondition.jsp">���� ���� �˻�</a></td>
	<td><a href="../view/ShowMyAllRating.jsp">���� �򰡳��� ��ȸ</a></td>
	<td><a href="../view/Mypage.jsp">����������</a></td>
	<td><a href="../func/LogOut.jsp">�α׾ƿ�</a></td></tr>
</table>
	
<br><br>
<%

out.println("<form method=\"post\" action=\"../view/SearchMovieByConditionResult.jsp\">");
out.print("���� ���� - ");
out.println("<select name='type'>");
out.print("<option value='");
out.print("no");
out.print("'>"+"���� ����"+"</option>");
out.print("<option value='");
out.print("Movie");
out.print("'>"+"Movie"+"</option>");
out.print("<option value='");
out.print("TV Series");
out.print("'>"+"TV Series"+"</option>");
out.print("<option value='");
out.print("KnuMovieDB Original");
out.print("'>"+"KnuMovieDB Original"+"</option>");
out.print("</select>");

out.print("<br><br>");
out.print("���� �帣 - ");
out.println("<select name='genre'>");
out.print("<option value='");
out.print("no");
out.print("'>"+"���� ����"+"</option>");

GenreDAO genre_dao = new GenreDAO();
List<GenreDTO> genre_list = genre_dao.list_for_all();

for (GenreDTO dto : genre_list) {
	out.print("<option value='");
	out.print(dto.getName());
	out.print("'>"+dto.getName()+"</option>");
}
out.print("</select>");


out.print("<br><br>");
out.print("���� ���� - ");
out.println("<select name='version'>");
out.print("<option value='");
out.print("no");
out.print("'>"+"���� ����"+"</option>");

NationalityDAO nation_dao = new NationalityDAO();
List<NationalityDTO> nation_list = nation_dao.list_for_all();

for (NationalityDTO dto : nation_list) {
	out.print("<option value='");
	out.print(dto.getShort_name());
	out.print("'>"+dto.getShort_name()+"</option>");
}
out.print("</select><br><br>");

out.print("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"������ ���ǵ�� �˻�\"></form>");

%>

	
	
	
	
</body>
</html>