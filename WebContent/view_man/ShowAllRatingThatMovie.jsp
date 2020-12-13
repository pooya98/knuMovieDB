<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.RatingDAO, model.RatingDTO, model.MovieDAO, model.MovieDTO, java.util.List"%>
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
	out.println("�� �� : "+dto.getRateUser()+"<br>");
	
	
	RatingDAO dao_R = new RatingDAO();
	List<RatingDTO> RatingList = dao_R.ListThatMovie(request.getParameter("id").toString());
	
	int count =0;
	
	out.println("<table border=\"1\">");
	out.println("<th>ID</th>");
	out.println("<th>����</th>");
	out.println("<th>�ڸ�Ʈ</th>");
	
	for (RatingDTO dto2 : RatingList) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto2.getAccount_username()+"</td>");
		out.println("<td>"+dto2.getMy_rating()+"</td>");
		out.println("<td>"+dto2.getMy_comments()+"</td>");
		out.println("</tr>");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	
	if(count == 0) {
		out.println("�� ����.");
	}
	out.println("</table>");
	
	
	
%>
<br>
 <button onclick="history.back()">Ȯ��</button>
</body>
</html>