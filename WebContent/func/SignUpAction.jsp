<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="model.InsertUser, resource.R_class"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>knuMovieDB-SignUp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pw_check = request.getParameter("pw_check");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String sex = request.getParameter("sex");
	String address = request.getParameter("address");
	String birth = request.getParameter("birth");
	String job = request.getParameter("job");
	boolean check = true;

	if (id.replaceAll(" ", "").equals("") || pw.replaceAll(" ", "").equals("") || name.replaceAll(" ", "").equals("")
			|| pw_check.replaceAll(" ", "").equals("") || phone.replaceAll(" ", "").equals("")) {
		out.println("<script>");
		out.println("alert('필수 입력사항이 입력되지 않았습니다.');");
		out.println("history.back();");
		out.println("</script>");
		check = false;
	}

	if (check && !pw.equals(pw_check)) {
		out.println("<script>");
		out.println("alert('비밀번호 확인이 올바르지 않습니다.');");
		out.println("history.back();");
		out.println("</script>");
		check = false;
	}

	boolean phone_check = true;

	if (check) {

		if (phone.length() != 13) {
			out.println("<script>");
			out.println("alert('전화번호 입력이 올바르지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			check = false;
		} else {
			for (int i = 0; i <= 12; i++) {
		if (i == 3 || i == 8) {
			if (phone.charAt(i) != '-')
				phone_check = false;
		} else {
			if (phone.charAt(i) >= '0' && phone.charAt(i) <= '9') {
			} else {
				phone_check = false;
			}
		}
			}
		}

		if (phone_check == false) {
			out.println("<script>");
			out.println("alert('전화번호 입력이 올바르지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			check = false;
		}
	}

	boolean birth_check = true;

	if (check) {

		if (birth.replaceAll(" ", "").length() > 0) {
			if (birth.length() != 10) {
				birth_check = false;
			}
			else{
				for (int i = 0; i <= 9; i++) {
					if (i == 4 || i == 7) {
						if (birth.charAt(i) != '-'){
							birth_check = false;
							break;
						}
					} else {
						if (birth.charAt(i) >= '0' && birth.charAt(i) <= '9') {
	
						} else {
							birth_check = false;
							break;
						}
					}
				}
			}
		}

		if (birth_check == false) {
			out.println("<script>");
			out.println("alert('생년월일 입력이 올바르지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			check = false;
		}

	}

	if (sex.equals("No")) {
		sex = "";
	}

	if (check) {
		R_class RC = new R_class();
		RC.put("signUp_id", id);

		InsertUser insert_user = new InsertUser();

		if (insert_user.idDuplicationCheck() == true) {
			out.println("<script>");
			out.println("alert('이미 존재하는 아이디입니다.');");
			out.println("history.back();");
			out.println("</script>");
			check = false;
		}
	}

	if (check) {
		R_class RC = new R_class();
		RC.put("signUp_id", id);
		RC.put("signUp_pw", pw);
		RC.put("signUp_name", name);
		RC.put("signUp_contact", phone);
		RC.put("signUp_address", address);
		RC.put("signUp_sex", sex);
		RC.put("signUp_birth", birth);
		RC.put("signUp_job", job);

		InsertUser insert_user = new InsertUser();

		if (insert_user.insert_user() == true) {
			out.println("<script>");
			out.println("alert('회원가입 완료!');");
			out.println("location.href='../view/SignIn.jsp';");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('이미 존재하는 아이디 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
	%>
</body>
</html>