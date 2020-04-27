package com.sgic.internal.login.securityjwt;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.eureka.common.security.JwtConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.login.request.LoginRequest;
import com.sgic.internal.login.servicesimpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter   {
	
	// We use auth manager to validate the user credentials
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	
	private final JwtConfig jwtConfig;
    
	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, JwtConfig jwtConfig) {
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;
		
		// By default, UsernamePasswordAuthenticationFilter listens to "/login" path. 
		// In our case, we use "/auth". So, we need to override the defaults.
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			
			// 1. Get credentials from request
			LoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
			
			// 2. Create auth object (contains credentials) which will be used by auth manager
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					creds.getUsernameOrEmail(), creds.getPassword(), Collections.emptyList());
			
			// 3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
			return authManager.authenticate(authToken);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Upon successful authentication, generate a token.
	// The 'auth' passed to successfulAuthentication() is the current authenticated user.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		try {

		
		
		String jwt = getJwt(request);
		if (jwt != null && validateJwtToken(jwt)) {
			String username = getUserNameFromJwtToken(jwt);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	} catch (Exception e) {
		logger.error("Can NOT set user authentication -> Message: {}", e);
	}

		chain.doFilter(request, response);
		
		
//		
//		Long now = System.currentTimeMillis();
//		String token = Jwts.builder()
//			.setSubject(auth.getName())	
//			// Convert to list of strings. 
//			// This is important because it affects the way we get them back in the Gateway.
//			.claim("authorities", auth.getAuthorities().stream()
//				.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//			.setIssuedAt(new Date(now))
//			.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
//			.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
//			.compact();
//		
//		// Add token to header
//		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
	}
	
	// A (temporary) class just to represent the user credentials
	public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtConfig.getSecret())
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
	
	 public boolean validateJwtToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(authToken);
	            return true;
	        } catch (SignatureException e) {
	            logger.error("Invalid JWT signature -> Message: {} ", e);
	        } catch (MalformedJwtException e) {
	            logger.error("Invalid JWT token -> Message: {}", e);
	        } catch (ExpiredJwtException e) {
	            logger.error("Expired JWT token -> Message: {}", e);
	        } catch (UnsupportedJwtException e) {
	            logger.error("Unsupported JWT token -> Message: {}", e);
	        } catch (IllegalArgumentException e) {
	            logger.error("JWT claims string is empty -> Message: {}", e);
	        }
	        
	        return false;
	    }
	 private String getJwt(HttpServletRequest request) {
			String authHeader = request.getHeader("Authorization");

			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				return authHeader.replace("Bearer ", "");
			}

			return null;
		}
	
	
}