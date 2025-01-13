package com.springprojects.virtualbookstore.config;

import java.io.IOException;
import java.security.Key;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtValidator extends OncePerRequestFilter {
	
	private final JwtProvider jwtProvider;
	
	public JwtValidator(JwtProvider jwtProvider) {
		this.jwtProvider=jwtProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt = request.getHeader(JwtConstants.JWT_HEADER);

		if (jwt != null) {
			System.out.println("jwtoriginal "+jwt.toString());
			jwt = jwt.substring(7);
			System.out.println("jwt "+jwt.toString());
			try {
				Key key = jwtProvider.getKey();
				System.out.println("key "+key);
				Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				System.out.println("claims "+claims);
				String email = String.valueOf(claims.get("email"));
				System.out.println("email "+email);
				String authorities = String.valueOf(claims.get("authorities"));
				System.out.println("authorities "+authorities);
				List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
				Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, auths);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BadCredentialsException("Invalid token.... from jwt validator");
			}
		}

		filterChain.doFilter(request, response);
	}
}
