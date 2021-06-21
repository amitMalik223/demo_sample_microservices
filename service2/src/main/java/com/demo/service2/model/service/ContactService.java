package com.demo.service2.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.service2.model.Contact;

@Service
public class ContactService {

	private final List<Contact> contactList = Arrays.asList(new Contact(1, 1, "Jagbir Malik", "jagbir@gmail.com"),
			new Contact(2, 1, "Krishna Malik", "krishna@gmail.com"), new Contact(3, 1, "Renu Malik", "renu@gmail.com"),
			new Contact(4, 1, "Ritu Malik", "ritu@gmail.com"), new Contact(5, 2, "Ramehar Redhu", "ramehar@gmail.com"),
			new Contact(6, 2, "Vinay Redhu", "Vinay@gmail.com"),
			new Contact(7, 3, "Sandeep Saroha", "sandeep@gmail.com"),
			new Contact(8, 3, "Pankaj Saroha", "pankaj@gmail.com"),
			new Contact(9, 3, "Pradeep Saroha", "pradeep@gmail.com"),
			new Contact(10, 4, "Utkarsh Saroha", "utkarsh@gmail.com"),
			new Contact(11, 4, "Aayush Saroha", "aayush@gmail.com"),
			new Contact(12, 5, "Nipun Jaglan", "nipun@gmail.com"),
			new Contact(13, 6, "Sumit Saroha", "Sumit@gmail.com"), new Contact(14, 6, "Ritu Saroha", "ritu@gmail.com"),
			new Contact(15, 6, "Utkarsh Saroha", "utkarsh@gmail.com"),
			new Contact(16, 7, "Sumit Saroha", "sumit@gmail.com"), new Contact(17, 7, "Ritu Saroha", "ritu@gmail.com"),
			new Contact(18, 7, "Aayush Saroha", "jagbir@gmail.com"),
			new Contact(19, 8, "Deepanshu Jaglan", "deepanshu@gmail.com"),
			new Contact(20, 8, "Renu Jaglan", "renu@gmail.com"),
			new Contact(21, 9, "Sandeep Narwal", "sandeep@gmail.com"),
			new Contact(22, 9, "Rajbir Narwal", "rajbir@gmail.com"),
			new Contact(23, 9, "Krishna Narwal", "krishna@gmail.com"),
			new Contact(24, 10, "Ramchandra Narwal", "ramchandra@gmail.com"),
			new Contact(25, 10, "Shivnarayan Narwal", "shivnarayan@gmail.com"));

	public List<Contact> getContactListByUserId(int userId) {
		return this.contactList.stream().filter(contact -> contact.getUserId() == userId).collect(Collectors.toList());
	}
}
