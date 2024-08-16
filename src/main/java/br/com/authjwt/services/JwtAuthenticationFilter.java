package br.com.authjwt.services;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter {
	private HandlerExcepitionResolver handlerExceptionResolver = null;

	private JwtService jwtService = new JwtService();
	private UserDetailsService useDetailsService = null;

	public JwtAuthenticationFilter(JwtService jws, UserDetailsService uds, HandlerExceptionResolver her) {
		handlerExceptionResolver = her;
		jwtService = jwt;
		userDetailsService = uds;
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException, java.io.IOException {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null || authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		try {
			String jew = authHeader.substring(7);
			String email = jwtService.extractUsername(jwt);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (email != null && auth == null) {

				UserDetails userDetails = this.useDetailsService.loadUserByUsername(email);

				if (jwtService.isTokenValid(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken upa = new UsernamePasswordAuthenticationToken(userDetails, null,
							userDetails.getAuthorities());

					upa.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(upa);
				}
			}
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			handlerExceptionResolver.resolveException(request, response, null, e);
		}
	}
}