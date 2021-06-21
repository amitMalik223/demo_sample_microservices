package com.demo.service2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service2.model.Contact;
import com.demo.service2.model.service.ContactService;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/{userId}")
	public List<Contact> getContactListByUserId(@PathVariable("userId") int userId) {
		return this.contactService.getContactListByUserId(userId);
	}
}
