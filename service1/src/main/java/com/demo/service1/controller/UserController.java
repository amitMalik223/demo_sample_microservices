package com.demo.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service1.model.User;
import com.demo.service1.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return this.userService.getUserById(userId);
	}
}
