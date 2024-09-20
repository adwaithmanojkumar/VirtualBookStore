package com.springprojects.virtualbookstore.config;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	private String secretKey = JwtConstants.SECRET_KEY;
	
	public JwtProvider() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public String generateToken(Authentication auth) {
		String jwt = Jwts.builder().setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+846000000L))
				.claim("email", auth.getName())
				.claim("authorities", auth.getAuthorities())
				.signWith(getKey()).compact();
		System.out.println("jwt1 "+jwt);
		return jwt;
	}
	
	public Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String getEmailForToken(String jwt) {
		jwt = jwt.substring(7);
		Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
		String email = String.valueOf(claims.get("email"));
		System.out.println("email1 "+email);
		return email;
	}
}
