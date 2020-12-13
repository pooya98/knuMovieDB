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
	<tr><td><a href="../view_man/Mypage.jsp">���������� Ȩ</a></td>
	<td><a href="../view_man/ShowMyInfo.jsp">ȸ������ ��ȸ</a></td>
    <td><a href="../view_man/ModifyMyInfo.jsp">ȸ������ ����</a></td>
	<td><a href="../view_man/ModifyPassword.jsp">��й�ȣ ����</a></td>
	<td><a href="../view_man/DropAccount.jsp">ȸ��Ż��</a></td>
</table>

<%
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = dao.getUserInfo(session.getAttribute("username").toString());
	out.println("<br>[���� ����� ������ȣ : "+dto.getId()+"]<br><br>");
	out.println("[���� ����� id : "+dto.getUsername()+"]<br><br>");
	
	out.println("[���� ����� �̸� : "+dto.getName()+"]");
	out.println("<form method=\"post\" action=\"../func/ModifyName.jsp\">");
	out.println(" ---> ������ ����� �̸�* : <input type=\"text\" class=\"form-control\" placeholder=\"������ �̸�\" name=\"name\" maxlength=\"20\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� ����ó : "+dto.getContact()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyContact.jsp\">");
	out.println(" ---> ������ ����� ����ó* : <input type=\"text\" class=\"form-control\" placeholder=\"������ ����ó(xxx-xxxx-xxxx)\" name=\"contact\" maxlength=\"13\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� �ּ� : "+dto.getAddress()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyAddress.jsp\">");
	out.println(" ---> ������ ����� �ּ� : <input type=\"text\" class=\"form-control\" placeholder=\"������ �ּ�\" name=\"address\" maxlength=\"100\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� ���� : "+dto.getSex()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifySex.jsp\">");
	out.println(" ---> ������ ����� ���� : SEX&nbsp;&nbsp;<select name='sex'><option value='No'>����</option><option value='M'>����</option><option value='F'>����</option><option value='No'>���þ���</option></select>");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� ���� ���� : "+dto.getBirth()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyBirth.jsp\">");
	out.println(" ---> ������ ����� ������� : <input type=\"text\" class=\"form-control\" placeholder=\"������ �������(yyyy-mm-dd)\" name=\"birth\" maxlength=\"10\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� ���� : "+dto.getJob()+"]<br>");
	out.println("<form method=\"post\" action=\"../func/ModifyJob.jsp\">");
	out.println(" ---> ������ ����� ���� : <input type=\"text\" class=\"form-control\" placeholder=\"������ ��������\" name=\"job\" maxlength=\"20\">");
	out.println("<input type=\"submit\" class=\"btn btn-primary form-control\" value=\"�����ϱ�\"></form><br><br>");
	out.println("[���� ����� ����� : "+dto.getMembership()+"]<br>");

%>	
	
</body>
</html>