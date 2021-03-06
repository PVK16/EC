package org.iiitb.EC.rest_services;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationFilter implements javax.servlet.Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";
	public static final String AUTHENTICATION_USERNAME = "username";
	public static final String AUTHENTICATION_PASSWORD = "password";

	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);

			// better injected
			AuthenticationService authenticationService = new AuthenticationService();

			boolean authenticationStatus = authenticationService
					.authenticate(authCredentials);

			if (authenticationStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}*/
	
	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String username = httpServletRequest
					.getHeader(AUTHENTICATION_USERNAME);
			String password = httpServletRequest
					.getHeader(AUTHENTICATION_PASSWORD);

			// better injected
			AuthenticationService authenticationService = new AuthenticationService();

			boolean authenticationStatus = authenticationService
					.authenticate(username, password);

			if (authenticationStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}*/
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String username = "";
			String password = "";
			try {
				username = httpServletRequest.getHeader(AUTHENTICATION_USERNAME);
				password = httpServletRequest.getHeader(AUTHENTICATION_PASSWORD);
			}catch(Exception e) {
				
			}
			
			// better injected
			AuthenticationService authenticationService = new AuthenticationService();

			boolean authenticationStatus = authenticationService
					.authenticate(username, password);

			if (authenticationStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}else {
			
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
