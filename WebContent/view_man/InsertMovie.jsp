<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="resource.R_class"%>
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


<form method="post" action="../func/InsertMovie.jsp">
	<h3>* ǥ�ô� �� �Է��ؾߵǴ� �����Դϴ�.</h3>
     ���� ����*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="���� ����" name="title" maxlength="50"><br>
     ���� ����*&nbsp;&nbsp;<select name='type'><option value='Movie'>Movie</option><option value='TV Series'>TV Series</option><option value='KnuMovieDB Original'>KnuMovieDB Original</option></select><br>
     ���� �帣*&nbsp;&nbsp;<select name='genre'><option value='Action'>Action</option><option value='Comedy'>Comedy</option><option value='Romance'>Romance</option><option value='SF'>SF</option><option value='Honor'>Honor</option><option value='Fantasy'>Fantasy</option></select><br>
     ���� ����ð�*&nbsp;&nbsp;<input type="number" class="form-control" placeholder="���� ����ð�(��)" name="runtime" maxlength="3"><br>
     ���� ������*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="������(yyyy-mm-dd)" name="start_date" maxlength="12"><br>
     ���� original version*&nbsp;&nbsp;<select name='version'><option value='KR'>KR</option><option value='US'>US</option><option value='JP'>JP</option><option value='CN'>CN</option><option value='IN'>IN</option></select><br>
 
     <br>
     <input type="submit" class="btn btn-primary form-control" value="Movie ���">
</form>


</body>
</html>