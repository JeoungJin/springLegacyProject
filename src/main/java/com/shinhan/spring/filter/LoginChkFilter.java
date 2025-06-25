package com.shinhan.spring.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @WebFilter : 서블릿3버젼부터 지원. 하위버젼은 web.xml를 이용해서 filter등록
 * LoginChkFilter는 .do라는 요청시에만 수행하도록 하기 
 */
@WebFilter("*.do") //, dispatcherTypes = DispatcherType.REQUEST)
public class LoginChkFilter implements Filter {
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("LoginChkFilter 요청주소 확인:" + req.getRequestURL());
		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
}
