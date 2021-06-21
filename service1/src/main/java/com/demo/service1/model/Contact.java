package com.demo.service1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {

	private int id;

	private int userId;

	private String name;

	private String email;

	public Contact(int id, int userId, String name, String email) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + this.id + ", userId=" + this.userId + ", name=" + this.name + ", email=" + this.email + "]";
	}
}
