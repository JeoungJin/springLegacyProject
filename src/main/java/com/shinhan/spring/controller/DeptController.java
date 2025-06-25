package com.shinhan.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.spring.model.dept.DeptDTO;
import com.shinhan.spring.model.dept.DeptService;
import com.shinhan.spring.model.emp.EmpDTO;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@GetMapping("/deptlist.do")
	public void selectAll(Model model, HttpServletRequest request, HttpSession session) {
		
		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		System.out.println("이 요청을 보낸 클라이언트의 IP주소: " + ip);
		System.out.println("요청주소:" + uri);
		
		EmpDTO emp = EmpDTO.builder()
				.first_name("주인장")
				.build();
		session.setAttribute("loginEmp", emp);
		
		//redirect시 받은 정보를 얻기
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			model.addAttribute("resultMessage", flashMap.get("resultMessage"));
		}
		model.addAttribute("deptListData", deptService.selectAll());
	}
	@GetMapping("/deptinsert.do")
	public void insertForm() {		
	}
	
	//@ModelAttribute("dept") : param으로 받은 data를 다시 view에서 사용하기위해 저장 
	@PostMapping("/deptinsert.do")//, BindingResult bResult
	public  String insertPost( @ModelAttribute("dept")   DeptDTO dept ) {
		//System.out.println(bResult.getFieldValue("manager_id"));
		int result = deptService.insertDept(dept);
		return "dept/result";  //forward
	}	
	@PostMapping("/deptSaveAjax.do")
	public @ResponseBody String deptsaveAjax(@RequestParam("job")  String job, 
			DeptDTO dept) {
		int result = 0;
		if(job.equals("insert")) {
			result = deptService.insertDept(dept);
		} else {
			result = deptService.updateDept(dept);
		}
		return result+"";
	}
	
	
	//@RequestParam("deptid")생략가능 
	@GetMapping("/deptdetail.do")
	public void detail( @RequestParam("deptid") int deptid, Model model) {
		model.addAttribute("dept",  deptService.selectById(deptid));
	}	
	//post일때 request.getParameter("")하기전에 
	//request.setCharacterEncoding("utf-8")===>Spring 제공Filter로 해결한다.	
	/* response.setContentType("text/html/charset=utf-8");
	 * response.getWriter().append("한글");
	 */
	
	
	//@ModelAttribute : view에 data넘기기, view(JSP) data받기, 생략가능  
	@PostMapping(value = "/deptdetail.do", produces = "text/plain;charset=utf-8")
	public  String update(@ModelAttribute("aa") DeptDTO dept, RedirectAttributes redirectAttr) {
		System.out.println("jsp의 form으로 들어온 data:" + dept);
		int result = deptService.updateDept(dept);
		//redirect는 요청이 전달되지않음 
		redirectAttr.addFlashAttribute("resultMessage", result>0?"수정성공(Flash)":"수정실패(Flash)");
		return  "redirect:deptlist.do";
	}
	
	@GetMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public  String delete(int deptid, RedirectAttributes redirectAttr ) {
		int result = deptService.deleteDept(deptid);
		redirectAttr.addFlashAttribute("resultMessage", result>0?"삭제성공(Flash)":"삭제실패(Flash)");
		return "redirect:deptlist.do";  //재요청 
		
	}
	
	//같은이름의 변수의 값이 여러개(배열)받아서 처리 
	@PostMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public String detail( @RequestParam("del")  int[] deptidArr ) {
		 
		int result = 0;
		for(int deptid:deptidArr) {
			result += deptService.deleteDept(deptid);
		}
		return "redirect:deptlist.do";
		
	}
	
	@GetMapping("/deptlist2.do")
	public @ResponseBody List<DeptDTO>  selectAlldeptWithemp(){
		List<DeptDTO> list = deptService.selectAlldeptWithemp();
		System.out.println(list);		
		return list;
		 
	}
}
















