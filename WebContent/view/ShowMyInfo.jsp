<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.AccountDAO, model.AccountDTO"%>
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
	<td>����������</td>
	<td><a href="../func/LogOut.jsp">�α׾ƿ�</a></td></tr>
</table>
	
	<br><br>
<table border=\"1\">
	<tr><td><a href="../view/Mypage.jsp">���������� Ȩ</a></td>
	<td>ȸ������ ��ȸ</td>
    <td><a href="../view/ModifyMyInfo.jsp">ȸ������ ����</a></td>
	<td><a href="../view/ModifyPassword.jsp">��й�ȣ ����</a></td>
	<td><a href="../view/DropAccount.jsp">ȸ��Ż��</a></td>
</table>

<%
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = dao.getUserInfo(session.getAttribute("username").toString());
	out.println("<br>����� ������ȣ : "+dto.getId()+"<br>");
	out.println("����� id : "+dto.getUsername()+"<br>");
	out.println("����� �̸� : "+dto.getName()+"<br>");
	out.println("����� ����ó : "+dto.getContact()+"<br>");
	out.println("����� �ּ� : "+dto.getAddress()+"<br>");
	out.println("����� ���� : "+dto.getSex()+"<br>");
	out.println("����� ���� ���� : "+dto.getBirth()+"<br>");
	out.println("����� ���� : "+dto.getJob()+"<br>");
	out.println("����� ����� : "+dto.getMembership()+"<br>");

%>	
	
</body>
</html>