<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원조회</title>
<%@ include file="../common/header.jsp" %>
 <link rel="stylesheet" href="${cpath}/resources/css/empAll.css"> 
<script src="${cpath}/resources/js/empAll.js"></script>
<script src="${cpath}/resources/js/empAll2.js"></script>
 <script>
    var cpath = "${cpath}";
    var name = '신한 DS 금융소프트 아카데미';
    //console.log(cpath);
   // console.log(`\${name} 학습중!!!!!!!!!!`);
	$(function(){
		var message = "${resultMessage}";  //EL(서버가해석)
		if(message!=""){
			   alert( message );
		}
		 //load된후에 조회버튼 누르기 
		$("#dept_job").trigger("click"); 
	});
</script>
<script src="${cpath}/resources/js/empAll_json.js"></script>

<script>
$(function(){
	$("#btnSelect").on("click", f_selectAll);
	$("#btnDetail").on("click", f_selectById);
	$("#btnInsert").on("click", f_insert);
	$("#btnUpdate").on("click", f_update);
	$("#btnDelete").on("click", f_delete);
});

 

</script>

</head>
<body>
<%--정적자원, jsp를 합쳐서 컴파일한다.(.java)->class->jsp실행  --%>
<div >
<p>[확인1] chat에서 session저장된 메시지 : ${lastMessage}</p>
<p>[확인2]chat에서 application에 저장된 totalUsers: ${totalUsers }</p>
</div>
<div id="container">
	<h3>Restful API사용하기</h3> 
 	<button id="btnSelect" class="btn btn-secondary">전체조회</button>
 	<input type="number" id="empid" value="100">
 	<button id="btnDetail" class="btn btn-secondary">상세보기</button>
 	<button id="btnInsert" class="btn btn-secondary">입력</button>
 	<button id="btnUpdate" class="btn btn-secondary">수정</button>
 	<button id="btnDelete" class="btn btn-secondary">삭제</button>
    <hr>
	  
	 	
<h1 class="title">직원목록</h1>
<a class="btn btn-success" href="${cpath}/emp/empinsert.do">신규직원등록</a>
<hr>

<div id="search1">
부서로조회:
<select id="deptid" multiple="multiple" >
  <option value="0" selected="selected">부서전체</option>
  <c:forEach items="${deptlist}" var="dept">
    <option value="${dept.department_id}" >
         ${dept.department_id}-${dept.department_name}
    </option>
  </c:forEach>
</select>

직책으로조회:
<select id="jobid">
  <option value="all" selected="selected">직책전체</option>
  <c:forEach items="${joblist}" var="job">
    <option>${job.jobId}</option>
  </c:forEach>
</select>
급여조회(이상):<input type="number" id="salary" value="1000">
입사일(이상) :<input type="date" id="hire_date" value="2000-01-01">
 <input type="checkbox" id="date_check">ALL
<button id="dept_job" class="btn btn-primary" >조건조회</button>

</div>


<hr>
급여:<input type="number" id="sal" value="5000">이상
 <button id="search1">직원찾기(스타일변경)</button>
 찾을문자:<input type="text" id="search2"  >

<hr>
<table class="table table-striped">
 <caption>모든직원List</caption>
 <thead>
   <tr>
     <th>순서</th>
     <th>로그인여부</th>
     <th>직원번호</th>
     <th>이름</th>
     <th>성</th>
     <th>급여</th>
     <th>이메일</th>     
     <th>부서</th>
     <th>커미션</th>
     <th>메니저</th>
     <th>전화번호</th>
     <th>직책</th>
     <th>입사일</th>
     <th>삭제</th>
   </tr>
 </thead>
 <tbody id="here">
 
 </tbody>
</table>
</div>
</body>
</html>







