<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.RatingDAO, model.RatingDTO, java.util.List"%>
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
	
<%
	int movie_id = Integer.parseInt(request.getParameter("movie_id").toString());

	RatingDAO dao = new RatingDAO();

	RatingDTO dto = new RatingDTO();
	
	dto = dao.Rating_info(session.getAttribute("username").toString(), movie_id);

	out.println("<h3>���� �� ����ȸ</h3>");
	
	out.println("���� :"+dto.getMovie_title()+"<br>");
	out.println("���� :"+dto.getMovie_type()+"<br>");
	out.println("�帣 :"+dto.getMovie_genre()+"<br>");
	out.println("������ :"+dto.getMovie_start_date().substring(0,10)+"<br>");
	out.println("����ð� :"+dto.getMovie_runtime()+"<br>");
	out.println("���� :"+dto.getMovie_rating()+"<br><br>");
	
	
	out.println("���� ���� :"+dto.getMy_rating()+"<br>");
	out.println("���� �ı� :"+dto.getMy_comments()+"<br><br>");
	
	
%>
<button onclick="history.back()">Ȯ��</button>
	
	
	
</body>
</html>