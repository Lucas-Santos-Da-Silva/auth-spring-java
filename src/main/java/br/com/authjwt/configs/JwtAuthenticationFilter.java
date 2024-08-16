package br.com.authjwt.configs;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.HandlerExceptionResolver;

import br.com.authjwt.services.JwtService;

public class JwtAuthenticationFilter {
	private final HandlerExceptionResolver handlerExceptionResolver = null;
	
	private final JwtService jwtService;
	private final UserDetailsService UserDetailsService = null;
}
