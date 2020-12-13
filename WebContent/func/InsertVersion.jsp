<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="model.VersionDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String movie_id = session.getAttribute("selected_movie_id").toString();
	String version = request.getParameter("version");
	String version_title = request.getParameter("version_title");
	
	if(version_title.replaceAll(" ","").equals("")){
		out.println("<script>");
		out.println("alert('필수 정보가 입력되지 않았습니다.');");
		out.println("history.back();");
		out.println("</script>");
	}else{
		VersionDAO dao = new VersionDAO();
		
		if(dao.Exist(movie_id, version)){
			out.println("<script>");
			out.println("alert('이미 해당 버전 정보가 존재합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else{
		
			if(dao.insert_version(Integer.parseInt(movie_id), version, version_title, "False")){
				out.println("<script>");
				out.println("alert('Version 등록에 성공 했습니다.');");
				out.println("location.href='../view_man/InsertContents.jsp';");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('Version 등록이 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
	}

%>
</body>
</html>