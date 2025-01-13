package com.springprojects.virtualbookstore.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

	public String generateToken(Authentication auth) {
		SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());

		return Jwts.builder().claim("email", auth.getName()).claim("authorities", auth.getAuthorities())// Include
																										// authorities
																										// here
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JwtConstants.EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public Key getKey() {
		return Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
	}

	public String getEmailForToken(String jwt) {
		jwt = jwt.substring(7);
		Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(jwt).getBody();
		String email = String.valueOf(claims.get("email"));
		System.out.println("email1 " + email);
		return email;
	}
}
