<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.CheckUser, model.AccountDAO, model.AccountDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	boolean check = true;
	
	if(id.equals("")){
		out.println("<script>");
		out.println("alert('아이디를 입력해주세요.');");
		out.println("history.back();");
		out.println("</script>");
		check = false;
	}
	
	if(check && pw.equals("")){
		out.println("<script>");
		out.println("alert('비밀번호를 입력해주세요.');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	CheckUser check_user = new CheckUser();
	
	if(check){
		
		String type;
		if(check_user.Exist(id, pw)){
			
			//R.put("id",id);
			//type = (String)R.get("user_type");
			
			AccountDAO dao = new AccountDAO();
			AccountDTO dto = new AccountDTO();
			
			dto = dao.getUserInfo(id);
			
			type = dto.getType();
			
			session.setAttribute("id", dto.getId());
			session.setAttribute("username", dto.getUsername());
			session.setAttribute("pw", dto.getPassword());
			session.setAttribute("name", dto.getName());
			session.setAttribute("contact", dto.getContact());
			session.setAttribute("type", dto.getType());
			session.setAttribute("address", dto.getAddress());
			session.setAttribute("sex", dto.getSex());
			session.setAttribute("birth", dto.getBirth());
			session.setAttribute("job", dto.getJob());
			session.setAttribute("membership", dto.getMembership());
			session.setAttribute("payment_date", dto.getPayment_date());
			
			if(type.equals("U")){
				out.println("<script>");
				out.println("alert('로그인 성공!');");
				out.println("location.href='../view/UserMain.jsp';");
				out.println("</script>");
			}
			else if(type.equals("M")){
				out.println("<script>");
				out.println("alert('로그인 성공!');");
				out.println("location.href='../view/ManagerMain.jsp';");
				out.println("</script>");
			}
			
			
		}else{
			out.println("<script>");
			out.println("alert('계정 정보가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
	
	
%>

</body>
</html>