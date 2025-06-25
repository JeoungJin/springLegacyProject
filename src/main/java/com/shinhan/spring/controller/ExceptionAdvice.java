package com.shinhan.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.shinhan.spring.model.except.PasswordException;

//전역적으로 예외처리 
@ControllerAdvice   
public class ExceptionAdvice {

	// 400 Bad Request 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> f_400(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("요청 데이터가 유효하지 않습니다.!!!!!");
    }

    // 415 Unsupported Media Type 처리
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> f_415(HttpMediaTypeNotSupportedException ex) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body("지원하지 않는 미디어 타입입니다@@@@.");
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> f_400_2(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("!!! :MismatchException!!@@@@.");
    }
    
	//--------------------다시 
	
    @ExceptionHandler(PasswordException.class)
    public String f_PawwordException(Exception ex, Model model,HttpServletRequest request) {
    	System.out.println("===PasswordException======");
    	ex.printStackTrace();
    	model.addAttribute("errorMessage", ex.getMessage());
    	return "error/error500";
    }
    
	@ExceptionHandler(Exception.class)
	public String f_exceptionProcess(Exception ex, Model model,HttpServletRequest request) {
		System.out.println("예외가 발생한 class이름:" + ex.getClass().getName());	
		model.addAttribute("url",request.getRequestURL());	
		ex.printStackTrace();
		
		if(ex instanceof HttpMediaTypeNotSupportedException) {
			model.addAttribute("errorMessage", "지원하지 않는 미디어 타입입니다@@@@.");
		}else if(ex instanceof MethodArgumentNotValidException || 
				ex instanceof MethodArgumentTypeMismatchException) {
			model.addAttribute("errorMessage", "요청 데이터가 유효하지 않습니다.!!!!!");
		}else {
			model.addAttribute("errorMessage", ex.getMessage());
		}
		
		
		return "error/error500";
	}
	
	

    
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView f_noHandler404(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/error404");
		mv.addObject("url", request.getRequestURL());
		mv.addObject("message","URL확인하세요");
		return mv;
	}
	
}









