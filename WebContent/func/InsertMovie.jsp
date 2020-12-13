<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MovieDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String genre = request.getParameter("genre");
		String runtime = request.getParameter("runtime");
		String start_date = request.getParameter("start_date");
		String version = request.getParameter("version");
		
	
	if(title.replaceAll(" ", "").equals("") || runtime.replaceAll(" ", "").equals("") || start_date.replaceAll(" ","").equals("")){
		out.println("<script>");
		out.println("alert('필수 정보가 입력되지 않았습니다.');");
		out.println("history.back();");
		out.println("</script>");
	}else{
		boolean runtime_check = true;
		boolean start_date_check = true;
		
		if(Integer.parseInt(runtime)<=0 || Integer.parseInt(runtime)> 1000){
			out.println("<script>");
			out.println("alert('영상 재생시간이 올바르지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			if (start_date.length() != 10) {
				start_date_check = false;
			}
			else{
				for (int i = 0; i <= 9; i++) {
					if (i == 4 || i == 7) {
						if (start_date.charAt(i) != '-'){
							start_date_check = false;
							break;
						}
					} else {
						if (start_date.charAt(i) >= '0' && start_date.charAt(i) <= '9') {
	
						} else {
							start_date_check = false;
							break;
						}
					}
				}
			}
			
			if(start_date_check){
				MovieDAO dao = new MovieDAO();
				if(dao.insertMovie(title, type, Integer.parseInt(runtime),genre, start_date, version)){
					out.println("<script>");
					out.println("alert('Movie 등록에 성공 했습니다.');");
					out.println("location.href='../view_man/InsertContents.jsp';");
					out.println("</script>");
				}else{
					out.println("<script>");
					out.println("alert('Movie 등록에 실패 했습니다.');");
					out.println("history.back();");
					out.println("</script>");
				}
			}else{
				out.println("<script>");
				out.println("alert('개봉일 입력이 올바르지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
	}
	%>
</body>