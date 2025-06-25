<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>




$(function(){
	$("#btnInsert").on("click", f_insert);
});

function f_insert(){
	console.log("f_insert---구현");
	var obj = { }; 
    var arr = $("#myfrm").serializeArray() ;
    $.each(arr, function(index, item){
    	obj[item.name] = item.value;
    });
	$.ajax({
		url:`${cpath}/emp/api/empinsert.do`,
		type:"post",
		data: JSON.stringify(obj),
		contentType:"application/json;charset=utf-8",
		success: function(responseData){
			console.log(responseData);
		}
	});
}
</script>
 
 
 <style>
  label { display: inline-block; width:150px; background-color: lightgray;}
</style>
 
</head>
<body>
<button  class="btn btn-primary"  id="btnInsert">입력(JSON이용)</button>
 

 <!--동적자원, 각각의 jsp를 컴파일후에 합친다.   JSTL은 자동으로 contextpath 인식  -->
<%--  <c:import url="/common/header.jsp"></c:import> --%>
 <!-- HTML tag는 contextpath 인식못함  -->
 <img src="${cpath}/resources/images/umbrella.jpg" width="100" height="100" />
 
 <h1>   신규 직원 등록</h1>
 <form  id="myfrm"   action="${cpath}/emp/empinsert.do" method="post">
 <input type="hidden" value="insert" name="jobselect">
  <label>직원번호:</label>
  <input   type="number" name="employee_id"  >
  <span id="here"> 여기 </span>
  <br>
 <label>이름:</label>
  <input name="first_name"  ><br>
 <label>성:</label>
  <input name="last_name"  ><br>
  <label>이메일:</label>
  <input name="email"  ><br>
  <label>전화번호:</label>
  <input name="phone_number"  ><br>
  
  <hr>
  <label>직책선택:</label>
  <select name="job_id">
    <c:forEach items="${joblist}" var="job">
       <option>${job.jobId}</option>
    </c:forEach>
  </select>
  
  <label>부서선택:</label>
  <select name="department_id">
     <c:forEach items="${deptlist}" var="dept">
        <option  value="${dept.department_id}">
            ${dept.department_name}
        </option>
     </c:forEach>
  </select>
 
  <hr> 
  <label>manager_id:</label>
  <input type="number" name="manager_id" ><br>
   
  <label>Salary:</label>
  <input type="number" name="salary"  ><br>
  <label>commission_pct:</label>
  <input type="text" name="commission_pct"  ><br>
  <label>입사일:</label>
  <input type="date" name="hire_date"  ><br>
  <input class="btn btn-danger"  type="submit" value="DB입력(일반Controller)">
  
 </form>
  <script>
  $(function(){
	 var isSave = true; 
	  
	 $("#myfrm").on("submit", function(event){
		 if(!isSave) {
			 alert("직원번로 입력확인~~~")
			 $("input[name='employee_id']").focus();
			 event.preventDefault(); //default 이벤트 취소 
			 return;
		 }
	 }); 
	  
     $("input[name='employee_id']").on("change", function(){
    	 var input_empid = $(this).val();
    	 
    	 $.ajax({
    		 url:"getEmpById.do?empid=" + input_empid ,
    		 success: function(responseData){
    			 //responseData: 0이면 없음 (가능), 1이면 있음(불가능)
    		     if(responseData==0){
    		    	 $("#here").html("가능한 아이디입니다.");
    		    	 $("#here").css("color", "blue");
    		    	 isSave = true;
    		     }else{
    		    	 $("#here").html("불가능한 아이디입니다.");
    		    	 $("#here").css("color", "red");
    		    	 $(this).val("");
    		    	 $(this).focus();
    		    	 isSave = false;
    		     }
    		 }		 
    	 });
     });
  });
 </script> 

</body>
</html>




