 $(()=>{
	 //()=>{} 화살표함수에서 this는 window, bind()함수로 object를 bind()하여 this설정가능 
	 $("#search2").on("keyup", function(){
		 var inputData = $(this).val();
		 console.log(inputData)
		 $("tbody tr").hide();
		 $(`td:contains(\${inputData})`).parent().show(); //<tr><td>aa</td></tr>
	 }); 
 });
 
 $(function(){
	$("#dept_job").on("click",function(){
		const select = document.getElementById("deptid"); //<option value="100">개발부</option>
		const selectedValues = Array.from(select.selectedOptions) 
		            .map(op => op.value);  //[10,20,30]
		var jobid = $("#jobid").val();
		var salary = $("#salary").val();
		var hire_date = $("#hire_date").val();
		var date_check = $("#date_check").prop("checked");
	    //?deptid=40&deptid=5;0&deptid=60
	    
	    //console.log($(select).val());
	    //console.log(jobid);		
	    //console.log(salary);
	    //console.log(hire_date);
	    //console.log(date_check);
	    
	    var jsonData = {"deptid":selectedValues,  //배열
				  "jobid":jobid,
				  "salary":salary,
				  "hire_date":hire_date,
				  "date_check":date_check
				  };
		$.ajax({
			url:"selectByCondition2.do",
			contentType: "application/json",
			type:"post",
			data: JSON.stringify(jsonData),
			success:function(responseData){
			     //forward된 JSP를 해석하여 HTML결과를 display한다. 
				$("#here").html(responseData);
			}
		}); 
	});
	
	

	/*
	$("#deptid").on("change", function(){
		var deptid = $(this).val();
		$.ajax({
			url:"selectByDept.do",
			data:{"deptid": deptid},
			success:function(responseData){
			  $("#here").html(responseData);	
			}
		});
	});
	
	
	$("#jobid").on("change", function(){
		var jobid = $(this).val();
		$.ajax({
			url:"selectByJob.do",
			data:{ jobid},
			success:function(responseData){
			  $("#here").html(responseData);	
			}
		});
	});*/
	
	
});
