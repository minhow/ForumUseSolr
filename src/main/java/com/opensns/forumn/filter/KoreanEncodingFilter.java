package com.opensns.forumn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class KoreanEncodingFilter implements Filter{
	private FilterConfig fc;
	private String enc;	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.fc=filterConfig;
		this.enc=fc.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(enc);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		fc=null;
	}

}
