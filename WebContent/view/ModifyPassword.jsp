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
	<td><a href="../view/ShowMyInfo.jsp">ȸ������ ��ȸ</a></td>
    <td><a href="../view/ModifyMyInfo.jsp">ȸ������ ����</a></td>
	<td>��й�ȣ ����</td>
	<td><a href="../view/DropAccount.jsp">ȸ��Ż��</a></td>
</table>
<br><br>
<form method="post" action="../func/ModifyPassword.jsp">
	
     ���� ��й�ȣ:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="���� ��й�ȣ" name="cur_password" maxlength="20"><br>
     ���ο� ��й�ȣ:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="���ο� ��й�ȣ" name="new_password" maxlength="20"><br>
     ���ο� ��й�ȣ Ȯ��:&nbsp;&nbsp;<input type="text" class="form-control" placeholder="���ο� ��й�ȣ Ȯ��" name="new_password_check" maxlength="20"><br>
     
     <br>
     <input type="submit" class="btn btn-primary form-control" value="�����ϱ�">
</form>
	
</body>
</html>