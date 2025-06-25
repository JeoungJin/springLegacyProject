package com.shinhan.spring.aop;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingIntercepter  implements HandlerInterceptor  {
	// Controller ���� ��
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("[PreHandle] ��û URI: " + request.getRequestURI());
        return true; // false ���� �� Controller�� ��û�� ���޵��� ����
    }
    // Controller ���� ��, ViewResolver ���� ��
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("[PostHandle] viewName: " + 
            (modelAndView != null ? modelAndView.getViewName() : "null"));
    }
    // �� ���������� �Ϸ�� ��
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        System.out.println("[AfterCompletion] ��û �Ϸ�");
    }
}



