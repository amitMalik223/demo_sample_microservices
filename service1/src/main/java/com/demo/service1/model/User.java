package com.demo.service1.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

	private int id;

	private String name;

	private String email;

	private List<Contact> contactList;

	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", contactList=" + this.contactList + "]";
	}
}
