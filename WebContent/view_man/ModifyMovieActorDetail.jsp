<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.DirectorDAO,model.DirectorDTO, java.util.List, model.VersionDAO, model.MovieDAO, model.MovieDTO, model.VersionDTO, model.ActorDAO, model.ActorDTO"%>
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

<%
	String movie_id = request.getParameter("movie_id");

	MovieDAO dao = new MovieDAO();
	MovieDTO dto = dao.detailInfo(Integer.parseInt(movie_id));
	
	out.println("<h3>'"+dto.getTitle()+"' ����ȸ</h3>");
	
	out.println("���� :"+dto.getTitle()+"<br>");
	out.println("���� :"+dto.getType()+"<br>");
	out.println("�帣 :"+dto.getGenre()+"<br>");
	out.println("������ :"+dto.getStart_date().substring(0,10)+"<br>");
	out.println("����ð� :"+dto.getRuntime()+"<br>");
	out.println("���� :"+dto.getRating()+"<br>");
	out.println("�� �� : "+dto.getRateUser()+"<br><br>");
	
	DirectorDAO dao_D = new DirectorDAO();
	DirectorDTO dto_D = dao_D.getMovieDirector(Integer.parseInt(movie_id));
	
	if(dto_D.getName() == null){
		out.println("����  : "+"���� ����"+"<br><br>");
	}else{
		out.println("����  : "+dto_D.getName()+"");
	}
	
%>
<button onclick="history.back()">�ڷΰ���</button>
<%
	out.println("<h3>'"+dto.getTitle()+"'�� ��ϵ� ��� ���</h3>");

	ActorDAO dao_A = new ActorDAO();
	List<ActorDTO> list = dao_A.get_list_this_movie(Integer.parseInt(movie_id));
	
	out.println("<table border=\"1\">");
	out.println("<th>���� ��ȣ</th>");
	out.println("<th>�̸�</th>");
	out.println("<th>�������</th>");
	out.println("<th>����</th>");
	out.println("<th>�� ��ȭ���� ����</th>");
	
	int count=0;
	
	for (ActorDTO dto2 : list) {
			count++;
			out.println("<tr>");
			out.println("<td>"+dto2.getId()+"</td>");
			out.println("<td>"+dto2.getName()+"</td>");
			out.println("<td>"+dto2.getBirth().substring(0,10)+"</td>");
			out.println("<td>"+dto2.getSex()+"</td>");
			out.println("<td>"+"<a href=\"../func/DeleteMovieActor.jsp?movie_id="+dto.getId()+"&actor_id="+dto2.getId()+"\">"+"�� ��ȭ���� ����"+"</a></td>");
			out.println("</tr>");
	}
	
	if(count == 0) {
		out.println("��ϵ� ��� ����.");
	}
	
	out.println("</table><br><br>");
	
	
	list = dao_A.get_list_not_exist(Integer.parseInt(movie_id));
	
	out.println("<h3>'"+dto.getTitle()+"'�� �߰� ������ ��� ���</h3>");
	out.println("<table border=\"1\">");
	out.println("<th>���� ��ȣ</th>");
	out.println("<th>�̸�</th>");
	out.println("<th>�������</th>");
	out.println("<th>����</th>");
	out.println("<th>�� ��ȭ�� �߰�</th>");
	
	for (ActorDTO dto2 : list) {
		count++;
		out.println("<tr>");
		out.println("<td>"+dto2.getId()+"</td>");
		out.println("<td>"+dto2.getName()+"</td>");
		out.println("<td>"+dto2.getBirth().substring(0,10)+"</td>");
		out.println("<td>"+dto2.getSex()+"</td>");
		out.println("<td>"+"<a href=\"../func/InsertMovieActor.jsp?movie_id="+dto.getId()+"&actor_id="+dto2.getId()+"\">"+"�� ��ȭ�� �߰�"+"</a></td>");
		out.println("</tr>");
		
	}
		if(count == 0) {
			out.println("��ϵ� ��� ����.");
		}
		
		out.println("</table><br><br>");
	
%>
</body>
</html>