<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sample1.jsp</h1>

<form action="sample7.do" method="get">
파라메터1 : <input name="userid" value="a"><br>
파라메터2 : <input name="userpass" value="금요일"><br>

<input type="submit" value="서버전송">

</form>


<p>1.문자 : ${subject }</p>
<p>2.숫자 : ${day }</p>
<p>3.VO : ${dept }</p>
<p>3.List : ${deptlist }</p>





</body>
</html>