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
	<td>�������� ���� ��ȸ</td>
	<td><a href="../view/SearchMovieByCondition">���� ���� �˻�</a></td>
	<td><a href="../view/ShowMyAllRating">���� �򰡳��� ��ȸ</a></td>
	<td><a href="../view/Mypage.jsp">����������</a></td>
	<td><a href="../func/LogOut.jsp">�α׾ƿ�</a></td></tr>
	</table>
	
<br><br>
<form method="post" action="../view/SearchMovieByTitleResult.jsp">
     <input type="text" class="form-control" placeholder="�˻��� ��ȭ����" name="title" maxlength="50">
<input type="submit" class="btn btn-primary form-control" value="�˻�">
</form>
	
	
	
	
</body>
</html>