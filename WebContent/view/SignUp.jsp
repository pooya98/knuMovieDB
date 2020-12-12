<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knuMovieDB</title>
</head>
<body>


<h2>SignUp</h2>

<form method="post" action="../func/SignUpAction.jsp">
	<h3>* 표시는 꼭 입력해야되는 정보입니다.</h3>
     ID*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="아이디" name="id" maxlength="15"><br>
     PW*&nbsp;&nbsp;<input type="password" class="form-control" placeholder="비밀번호" name="pw" maxlength="20"><br>
     PW 확인*&nbsp;&nbsp;<input type="password" class="form-control" placeholder="비밀번호 확인" name="pw_check" maxlength="20"><br>
     NAME*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="이름" name="name" maxlength="20"><br>
     PHONE*&nbsp;&nbsp;<input type="text" class="form-control" placeholder="전화번호(xxx-xxxx-xxxx)" name="phone" maxlength="13"><br>
     ADDRESS&nbsp;&nbsp;<input type="text" class="form-control" placeholder="주소" name="address" maxlength="100"><br>
     SEX&nbsp;&nbsp;<select name='sex'><option value='No'>성별</option><option value='M'>남자</option><option value='F'>여자</option><option value='No'>선택안함</option></select><br>
     BIRTH&nbsp;&nbsp;<input type="text" class="form-control" placeholder="생년월일(yyyy-mm-dd)" name="birth" maxlength="10"><br>
     JOB&nbsp;&nbsp;<input type="text" class="form-control" placeholder="직업정보" name="job" maxlength="20"><br>
     
     <br>
     <input type="submit" class="btn btn-primary form-control" value="회원가입">
</form>

<form method="post" action="../view/SignIn.jsp">
     <input type="submit" class="btn btn-primary form-control" value="가입취소">
</form>
</body>
</html>