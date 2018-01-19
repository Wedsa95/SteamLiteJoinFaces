package com.jensen.steamlite.controller.authenticationfilter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jensen.steamlite.UserHandler;


@WebFilter("/faces/user/*")
public class CheckUserSession implements Filter{

	@Inject
	private UserHandler userHandler;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response
			,FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filter doFilter Start");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
//		HttpSession session = req.getSession(false);
//		UserHandler user = (UserHandler) session.getAttribute("UserHandler");
		boolean test = userHandler.isSignedIn();
		System.out.println(test);
		if(test) {
			System.out.println("Filter Passage Ganted");
			chain.doFilter(request, response);
//			res.sendRedirect(req.getContextPath()+req.get);
		}else {
			System.out.println("Filter Passage False");
			System.out.println(req.getContextPath()+"/faces/login.xhtml");
			res.sendRedirect(req.getContextPath()+"/faces/login.xhtml");
		}
	
	}
	
	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig conf) throws ServletException {
		
	}
	
	
}
