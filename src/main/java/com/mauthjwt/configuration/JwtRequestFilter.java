package com.mauthjwt.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mauthjwt.service.JwtUserDetailsService;
import com.mauthjwt.util.Constantes;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader(Constantes.HEADER_AUTHORIZATION);
		
		String username = null;
		String jwtToken = null;
		
		if(!StringUtils.isEmpty(requestTokenHeader) && requestTokenHeader.startsWith(Constantes.BEARER_PREFIX)) {
			jwtToken= requestTokenHeader.substring(7);
			
			username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				/** user from database **/
				UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
				if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new 
							UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					
					usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					//set token in contexte spring
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				
			}
			filterChain.doFilter(request, response);
		}

	}

}
