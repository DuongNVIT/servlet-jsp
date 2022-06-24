package com.duongnv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duongnv.model.UserModel;
import com.duongnv.utils.SessionUtil;

public class AuthorizationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String url = httpServletRequest.getRequestURI().toString();
		System.out.println("33: " + url);
		if(url.contains("/login")) {
			chain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(url.equals("/servlet-jsp/")) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +"/login");
			return;
		}
		
		
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(httpServletRequest, "USERMODEL");
		System.out.println("40: " + userModel);
		if(userModel == null) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?message=accessdenied&alert=fail");
		} else {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
