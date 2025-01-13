package com.springprojects.virtualbookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//	@GetMapping("/profile")
//	public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException {
//		User user = userService.findUserProfileByJwt(jwt);
//		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
//	}
	
	@GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler() throws UserException {
        // Extract user details from SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null) {
            throw new UserException("User is not authenticated");
        }

        String email = (String) authentication.getPrincipal();  // Get user email from authentication object
        User user = userService.findUserProfileByEmail(email);  // Use email to retrieve user profile
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
