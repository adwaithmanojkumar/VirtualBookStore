package com.adwaith.learnspringsecurity.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosResources {
	
	private static final List<Todo> TODOS_LIST = List.of(new Todo("adwaith", "Learn AWS"),
								new Todo("adwaith", "Learn Spring"));
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/users/todos")
	public List<Todo> retrieveAllTodos() {
		return TODOS_LIST;
	}
	
	@GetMapping("/users/{username}/todos")
	public Todo retrieveATodo() {
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("/users/{username}/todos")
	public void addTodo(@PathVariable("username") String username,@RequestBody Todo todo) {
		logger.info("Created new todo {} for {}",todo,username);
		TODOS_LIST.add(todo);
	}
}

record Todo(String username, String description) {}