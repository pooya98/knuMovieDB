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
	String title = request.getParameter("title");
	if (title.equals("")) {
		out.println("<script>");
		out.println("alert('������ �Է����ּ���.');");
		out.println("history.back();");
		out.println("</script>");

	}else{
		MovieDAO dao = new MovieDAO();

		List<MovieDTO> list = dao.list_for_title_search(Integer.parseInt(session.getAttribute("id").toString()),title);

		int count=0;
		out.println("<br><br>");
		out.println("�˻��� ���� ����Ʈ");
		out.println("<button onclick=\"history.back()\">�ٽ� �˻��ϱ�</button>");
		out.println("<br>");

		out.println("<table border=\"1\">");
		out.println("<th>������ȣ</th>");
		out.println("<th>����</th>");
		out.println("<th>����</th>");
		out.println("<th>�帣</th>");
		out.println("<th>�󿵽ð�</th>");
		out.println("<th>������</th>");
		out.println("<th>����</th>");
		
		for (MovieDTO dto : list) {
			count++;
			out.println("<tr>");
			out.println("<a href=\"../view/UserMain.jsp\">");
			out.println("<td>"+dto.getId()+"</td>");
			out.println("<td>"+"<a href=\"../view_man/SearchMovieByTitleResultDetail.jsp?id="+dto.getId()+"\">"+dto.getTitle()+"</a></td>");
			out.println("<td>"+dto.getType()+"</td>");
			out.println("<td>"+dto.getGenre()+"</td>");
			out.println("<td>"+dto.getRuntime()+"</td>");
			out.println("<td>"+dto.getStart_date().substring(0, 10)+"</td>");
			out.println("<td>"+dto.getRating()+"</td>");
			out.println("</a>");
			out.println("</tr>");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		
		if(count == 0) {
			out.println("�˻��� ���� ����.");
		}
		
		System.out.println("</table>");	
	}
%>
	
	
	
	
</body>
</html>