package com.springprojects.virtualbookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.config.JwtProvider;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.UserServiceRepo;
import com.springprojects.virtualbookstore.request.LoginRequest;
import com.springprojects.virtualbookstore.response.AuthResponse;
import com.springprojects.virtualbookstore.service.CartService;
import com.springprojects.virtualbookstore.service.CustomUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private UserServiceRepo userRepo;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomUserServiceImplementation customUserService;
	private CartService cartService;
	
	public AuthController(UserServiceRepo userRepo, JwtProvider jwtProvider, PasswordEncoder passwordEncoder,
			CustomUserServiceImplementation customUserService, CartService cartService) {
		super();
		this.userRepo = userRepo;
		this.jwtProvider = jwtProvider;
		this.passwordEncoder = passwordEncoder;
		this.customUserService = customUserService;
		this.cartService = cartService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		User isEmailExist = userRepo.findByEmail(email);
		
		if (isEmailExist != null) { 
			throw new UserException("Email is already used for another account");
		}

		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);
		
		User savedUser = userRepo.save(createdUser);
		
//		System.out.println("User ID: " + savedUser.getId());
		Cart cart = cartService.createCart(savedUser);
		System.out.println(cart.getId());
		System.out.println(cart.getUser().getId());
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Signup success");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		Authentication authentication = authenticate(username,password);
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Signin success");
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(username);
		
		if(userDetails==null) {
			throw new BadCredentialsException("Invalid Username....");
		}
		
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password.....");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}
