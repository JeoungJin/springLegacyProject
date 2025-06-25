package com.shinhan.spring.aop;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingIntercepter  implements HandlerInterceptor  {
	// Controller 실행 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("[PreHandle] 요청 URI: " + request.getRequestURI());
        return true; // false 리턴 시 Controller로 요청이 전달되지 않음
    }
    // Controller 실행 후, ViewResolver 실행 전
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("[PostHandle] viewName: " + 
            (modelAndView != null ? modelAndView.getViewName() : "null"));
    }
    // 뷰 렌더링까지 완료된 후
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        System.out.println("[AfterCompletion] 요청 완료");
    }
}



