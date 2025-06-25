package com.shinhan.spring.controller;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.spring.model.dept.DeptService;
import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpRequestDTO;
import com.shinhan.spring.model.emp.EmpService;
import com.shinhan.spring.model.job.JobService;

import lombok.RequiredArgsConstructor;
 

@Controller
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {
	final EmpService empService;
	final JobService jobService;
	final DeptService deptService;
	
 
	 //@ResponseBody 생략시 무조건 forward
	@GetMapping("/getEmpById.do")
	public @ResponseBody  String f_empidChk( @RequestParam int empid) {
		EmpDTO emp =   empService.selectById(empid);
		return emp==null?"0":"1";
	}
	
	 
	
	@GetMapping("/emplist.do")
	public String selectAll(Model model, HttpServletRequest request) {
		
		//int i = 10/0;
		
		
		//redirect시 받은 정보를 얻기
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			model.addAttribute("resultMessage", flashMap.get("resultMessage"));
		}
		
		model.addAttribute("joblist", jobService.getAllJobs());
		model.addAttribute("deptlist", deptService.selectAll());
		return "emp/empAll";
	}
	
	/*
	 * request : param(get방식), body(post방식)
	 * JSON관련라이브러리가 없으면 
	 * WARN : org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver - Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/json;charset=UTF-8' not supported]
	 */
	
	@PostMapping("/selectByCondition2.do")	
	public  String f_condition2( @RequestBody EmpRequestDTO  data, Model model ) throws IOException {
        System.out.println(data);      
        Integer[] deptArr = data.getDeptid();        
        model.addAttribute("emplist",  empService.selectByCondition(deptArr, data.getJobid(),
        		data.getSalary(), data.getHire_date(), data.getDate_check()));
		return "emp/empByCondition";
	}
	
	@GetMapping("/empinsert.do")
	public void get_insert( Model model) {
		model.addAttribute("joblist", jobService.getAllJobs());
		model.addAttribute("deptlist", deptService.selectAll()); 
	}
	@PostMapping("/empinsert.do")
	public String post_insert( @ModelAttribute EmpDTO  emp, RedirectAttributes attr) {
		 System.out.println(emp);
		 
		 int result = empService.empInsert(emp);
		 attr.addFlashAttribute("resultMessage", result>0?"insert success":"insert fail");
		 return "redirect:emplist.do";
		 
	}
	
	@GetMapping("/empdetail.do")
	public void get_detail(@RequestParam("empid2") int empid, Model model) {
		model.addAttribute("joblist", jobService.getAllJobs());
		model.addAttribute("deptlist", deptService.selectAll()); 
		model.addAttribute("emp",  empService.selectById(empid));
	}
	@PostMapping("/empdetail.do")
	public String empUpdate(@ModelAttribute EmpDTO emp, RedirectAttributes attr) {
		 int result = empService.empUpdate(emp);
		 attr.addFlashAttribute("resultMessage", result>0?"update success":"update fail");
		 return "redirect:emplist.do";
	}
	@GetMapping("/empdelete.do")
	public String delete(int empid,RedirectAttributes attr) {
		 int result = empService.empDeleteById(empid);
		 attr.addFlashAttribute("resultMessage", result>0?"delete success":"delete fail");
		 return "redirect:emplist.do";
	}
	
	
	
	
	//@PostMapping("/selectByCondition2.do")	
	public String f_condition1( @RequestBody Map<String,Object> data ) throws IOException {
        System.out.println(data);      
        for(String key :data.keySet()) {     	 
        	System.out.println(key + ":" + data.get(key));
        }
        //0.윗부분 : json받기(문자).. "{    }"
		//1.JSON을 Object로 바꾼다.(parse) .....Jackson이 여기까지 자동으로 함 
        //2.해당 data추출한다.
        //3.조건조회
        //4.결과를 jsp페이지로 forward하여 HTML로 만든후 ajax호출로간다. 
		return "emp/empByCondition";
	}
	
	
	
	//@PostMapping("/selectByCondition2.do")
	public String f_condition1( HttpServletRequest request ) throws IOException {
		BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        } //'{deptid:[], job_id:""}'
        
        String json = jsonBuilder.toString();
        System.out.println(json);
        //0.윗부분 : json받기(문자).. "{    }"
		//1.JSON을 Object로 바꾼다.(parse)
        //2.해당 data추출한다.
        //3.조건조회
        //4.결과를 jsp페이지로 forward하여 HTML로 만든후 ajax호출로간다. 
		return "emp/empByCondition";
	}
	
	
	/*
	 * // 1. JSON 데이터 읽기
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        } //'{deptid:[], job_id:""}'
        
        String json = jsonBuilder.toString();
        System.out.println(json);
		
        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
        
        JsonArray deptArray = jsonObj.getAsJsonArray("deptid");
        String jobid = jsonObj.get("jobid").getAsString();
        int salary = jsonObj.get("salary").getAsInt();
        String hire_date = jsonObj.get("hire_date").getAsString();
		
        Integer[] deptArr = new Integer[deptArray.size()];
        for (int i = 0; i < deptArray.size(); i++) {
        	deptArr[i] = deptArray.get(i).getAsInt();
        }
        EmpService empService = new EmpService();
        request.setAttribute("emplist", 
        		empService.selectByCondition(deptArr, jobid, salary, hire_date));
        

	 */
	
//	@PostMapping(value = "/selectByCondition2.do", consumes = "application/json" )
//	public  String selectByCondition(@RequestBody Map<String,Object>  data , Model model  ) throws IOException {
//		
//		System.out.println(data);
//		
//		return "emp/empByCondition";
//		
//	}
	
	//@PostMapping(value = "/selectByCondition2.do", consumes = "application/json" )
	public  String selectByCondition2(@RequestBody Map<String,Object> data , Model model  ) throws IOException {
		ArrayList<String> deptList = (ArrayList) data.get("deptid");
		Integer[] arr = new Integer[deptList.size()];		
		for(int i=0;i<deptList.size(); i++) {
			arr[i] = Integer.parseInt( (String)deptList.get(i) );
		}
		
		
//		model.addAttribute("emplist", 
//				empService.selectByCondition(arr, "ST_CLERK", 3000, "2000-01-01"));
		
		
		
		//		// 1. JSON 데이터 읽기
//        BufferedReader reader = request.getReader();
//        StringBuilder jsonBuilder = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            jsonBuilder.append(line);
//        } //'{deptid:[], job_id:""}'
//        
//        String json = jsonBuilder.toString();
//        System.out.println(json);
		
		/*
		 * Gson gson = new Gson(); JsonObject jsonObj = gson.fromJson(json,
		 * JsonObject.class);
		 * 
		 * JsonArray deptArray = jsonObj.getAsJsonArray("deptid"); String jobid =
		 * jsonObj.get("jobid").getAsString(); int salary =
		 * jsonObj.get("salary").getAsInt(); String hire_date =
		 * jsonObj.get("hire_date").getAsString();
		 * 
		 * Integer[] deptArr = new Integer[deptArray.size()]; for (int i = 0; i <
		 * deptArray.size(); i++) { deptArr[i] = deptArray.get(i).getAsInt(); }
		 */
		//model.addAttribute("emplist", empService.selectByCondition(null, null, 0, null));
		return "emp/empByCondition";
	}
	
	
}













