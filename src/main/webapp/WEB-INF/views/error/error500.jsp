<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>[오류] 프로그램 문제발생</h1>
  <p><%=exception %></p>
  <p><%=exception.getMessage() %></p>
  
  <h2 style="color:red">메시지:${errorMessage }</h2>
  <h2>${url }</h2>
  <h2>${pageContext.request.contextPath}</h2>
</body>
</html>