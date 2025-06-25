<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  //default event에 대하여 .....이미 제공되는 이벤트핸들러가 있다.
  window.onload = function(){
	  
	  var frmObj = document.querySelector("#myfrm");
	  //2)고전방식으로 이벤트와 이벤트 핸들러 연결 
	 
	  frmObj.onsubmit = function(event){
		  var deptnameObj = document.querySelector('input[name="department_name"]');
		  var deptname = deptnameObj.value;
		  if(deptname.length < 5){
			  alert("부서이름은 5자리 이상입니다.");
			  deptnameObj.focus();
			  //default event를 취소하기 
			  //1)return false;
			  //2)preventDefault()
			  event.preventDefault();
			  return;
		  } 
		  alert("서버에 전송된다.");
	  }; 
	  
  }; 
   //1)inline방식으로 이벤트와 이벤트 핸들러 연결 
  function call(){
	  var deptnameObj = document.querySelector('input[name="department_name"]');
	  var deptname = deptnameObj.value;
	  if(deptname.length < 5){
		  alert("부서이름은 5자리 이상입니다.");
		  deptnameObj.focus();
		  //default event를 취소하기 
		  //1)return false;
		  return false;
		  //2)preventDefault()
		  //event.preventDefault();
		  //return;
	  } 
	  alert("서버에 전송된다.");
  }
  
   
  
</script>
</head>
<body>

<%-- <p>${sessionScope.dept }</p> --%>
 
<%@ include file="../common/header.jsp" %>
 
 <p>이미지</p>
 <img alt="" 
 width="100" height="100"
 src="${cpath}/resources/images/umbrella.jpg">
 
 <h1>부서 입력</h1>
 <!-- onsubmit="return call();" -->
<form id="myfrm" 
method="post"
action="deptinsert.do" > 
     <input type="hidden" name="job" value="insert" >
	 <label>부서코드 :</label> 
	 <input  type="number" name="department_id" required="required"   autofocus="autofocus" > <br>
	 <label>부서이름 :</label> 
	 <input name="department_name" required="required"> <br>
	 <label>메니저번호 :</label> 
	 <input type="number" name="manager_id" placeholder="존재하는 직원" > <br>
	 <label>지역코드 :</label> 
	 <input type="number" name="location_id" placeholder="존재하는 지역코드" > <br>
	 <input type="submit" value="입력">
	 <input type="reset" value="다시입력">
	 <br>
	 

</form>
 
 
 
</body>
</html>





