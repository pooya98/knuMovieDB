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

	out.println("<h3>"+username+" ��, ȯ���մϴ�."+"</h3>");
%>
<table border=\"1\">
	<tr><td><a href="../view/UserMain.jsp">Ȩ</a></td>
    <td><a href="../view/ShowAllMovie.jsp">��ü ���� ��ȸ</a></td>
	<td><a href="../view/SearchMovieByTitle.jsp">�������� ���� ��ȸ</a></td>
	<td>���� ���� �˻�</td>
	<td><a href="../view/ShowMyAllRating.jsp">���� �򰡳��� ��ȸ</a></td>
	<td><a href="../view/Mypage.jsp">����������</a></td>
	<td><a href="../func/LogOut.jsp">�α׾ƿ�</a></td></tr>
	</table>
	
<%
	MovieDAO dao = new MovieDAO();

	MovieDTO dto;
	
	dto = dao.detailInfo(Integer.parseInt(request.getParameter("id")));

	out.println("<h3>'"+dto.getTitle()+"' ����ȸ</h3>");
	
	out.println("���� :"+dto.getTitle()+"<br>");
	out.println("���� :"+dto.getType()+"<br>");
	out.println("�帣 :"+dto.getGenre()+"<br>");
	out.println("������ :"+dto.getStart_date().substring(0,10)+"<br>");
	out.println("����ð� :"+dto.getRuntime()+"<br>");
	out.println("���� :"+dto.getRating()+"<br>");
	out.println("�� �� : "+dto.getRateUser()+"<br><br>");
	
	session.setAttribute("selected_movie_id", Integer.parseInt(request.getParameter("id")));
	
	
	out.println("<form method=\"post\" action=\"../func/InsertRating_Condition.jsp\">");
    out.println("<input type=\"text\" class=\"form-control\" placeholder=\"����(1~10��)\" name=\"point\" maxlength=\"2\"><br>");
    out.println("<input type=\"text\" class=\"form-control\" placeholder=\"�ڸ�Ʈ\" style=\"width:300px;height:200px;\" name=\"comment\" maxlength=\"100\"><br>");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"���ϱ�\"></form>");
%>


 <button onclick="history.back()">�ڷΰ���</button>
</body>
</html>