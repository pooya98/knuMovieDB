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
	RatingDAO dao = new RatingDAO();

	List<RatingDTO> list = dao.myList(session.getAttribute("username").toString());

	int count=0;

	out.println("<h3>���� �� ����Ʈ</h3>");
	


	out.println("<table border=\"1\">");
	out.println("<th>���� ������ȣ</th>");
	out.println("<th>����</th>");
	out.println("<th>����</th>");
	out.println("<th>�帣</th>");
	out.println("<th>�󿵽ð�</th>");
	out.println("<th>������</th>");
	out.println("<th>����</th>");
	out.println("<th>���� ����</th>");
	
	
	for (RatingDTO dto : list) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto.getMovie_id()+"</td>");
		out.println("<td>"+"<a href=\"../view/ShowRatingDetail.jsp?movie_id="+dto.getMovie_id()+"\">"+dto.getMovie_title()+"</a></td>");
		out.println("<td>"+dto.getMovie_type()+"</td>");
		out.println("<td>"+dto.getMovie_genre()+"</td>");
		out.println("<td>"+dto.getMovie_runtime()+"</td>");
		out.println("<td>"+dto.getMovie_start_date().substring(0, 10)+"</td>");
		out.println("<td>"+dto.getMovie_rating()+"</td>");
		out.println("<td>"+dto.getMy_rating()+"</td>");
		out.println("</tr>");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	
	if(count == 0) {
		out.println("�� ������ �������� �ʽ��ϴ�.");
	}
	
	System.out.println("</table>");
%>
	
	
	
	
</body>
</html>