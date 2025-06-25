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

//���������� ����ó�� 
@ControllerAdvice   
public class ExceptionAdvice {

	// 400 Bad Request ó��
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> f_400(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("��û �����Ͱ� ��ȿ���� �ʽ��ϴ�.!!!!!");
    }

    // 415 Unsupported Media Type ó��
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> f_415(HttpMediaTypeNotSupportedException ex) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body("�������� �ʴ� �̵�� Ÿ���Դϴ�@@@@.");
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> f_400_2(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("!!! :MismatchException!!@@@@.");
    }
    
	//--------------------�ٽ� 
	
    @ExceptionHandler(PasswordException.class)
    public String f_PawwordException(Exception ex, Model model,HttpServletRequest request) {
    	System.out.println("===PasswordException======");
    	ex.printStackTrace();
    	model.addAttribute("errorMessage", ex.getMessage());
    	return "error/error500";
    }
    
	@ExceptionHandler(Exception.class)
	public String f_exceptionProcess(Exception ex, Model model,HttpServletRequest request) {
		System.out.println("���ܰ� �߻��� class�̸�:" + ex.getClass().getName());	
		model.addAttribute("url",request.getRequestURL());	
		ex.printStackTrace();
		
		if(ex instanceof HttpMediaTypeNotSupportedException) {
			model.addAttribute("errorMessage", "�������� �ʴ� �̵�� Ÿ���Դϴ�@@@@.");
		}else if(ex instanceof MethodArgumentNotValidException || 
				ex instanceof MethodArgumentTypeMismatchException) {
			model.addAttribute("errorMessage", "��û �����Ͱ� ��ȿ���� �ʽ��ϴ�.!!!!!");
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
		mv.addObject("message","URLȮ���ϼ���");
		return mv;
	}
	
}









