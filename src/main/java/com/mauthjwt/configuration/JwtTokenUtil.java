package com.mauthjwt.configuration;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550185165626007488L;
	
	public static final Long JWT_TOKEN_VALIDITY = (long) (5 * 60 * 60);
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public <T> T getClaimFromToken(String token,Function<Claims, T> claimsResolver ) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGeneateToken(claims, userDetails.getUsername());
	}
	
	private Date  getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expirationDate= getExpirationDateFromToken(token);
		return new Date().before(expirationDate);
	}
	
	private String doGeneateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
		
	}
	
	public Boolean validateToken(String token,UserDetails userDetails ) {
		final String username = getUsernameFromToken(token);
		return username.equals(userDetails.getUsername()) && isTokenExpired(token);
		
	}
	
	
	

}
