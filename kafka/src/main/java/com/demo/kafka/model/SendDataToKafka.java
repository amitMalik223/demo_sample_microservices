package com.demo.kafka.model;

import lombok.Data;

@Data
public class SendDataToKafka {

	private final int id;

	private final String name;

	private final String email;

	public SendDataToKafka(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", email=" + this.email + "]";
	}
}
