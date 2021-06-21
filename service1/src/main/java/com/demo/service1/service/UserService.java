package com.demo.service1.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.service1.config.MailConfiguration;
import com.demo.service1.model.User;

@Service
public class UserService {

	private final String SERVICE_2_URL = "http://contact-service/api/v1/contact";

	private final String KAFKA_SERVICE_URL = "http://kafka-service/api/v1/kafka/sendDataToKafka";

	@Autowired
	private MailConfiguration mailConfiguration;

	private final List<User> userList = Arrays.asList(new User(1, "Amit Malik", "amit.malik12345@mailinator.com"),
			new User(2, "Meena Redhu", "meena@gmail.com"), new User(3, "Mandeep Saroha", "mandeep@gmail.com"),
			new User(4, "Ritu Saroha", "ritu.saroha@gmail.com"), new User(5, "Renu Jaglan", "renu.jaglan@gmail.com"),
			new User(6, "Aayush Saroha", "aayush.saroha@gmail.com"),
			new User(7, "Utkarsh Saroha", "utkarsh.saroha@gmail.com"),
			new User(8, "Nipun Jaglan", "nipun.jaglan@gmail.com"),
			new User(9, "Sumit Narwal", "sumit.narwal@gmail.com"),
			new User(10, "Deepak Narwal", "deepak.narwal@gmail.com"));

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User getUserById(int userId) {
		final List contactListByUserId = this.restTemplate
				.getForObject(this.SERVICE_2_URL + "/" + userId, List.class);
		final User user = this.userList.stream().filter(user1 -> user1.getId() == userId).collect(Collectors.toList())
				.get(0);
		user.setContactList(contactListByUserId);
		this.sendDataToKafka(user);
		this.mailConfiguration.sendEmail(user.getEmail());
		return user;
	}

	private boolean sendDataToKafka(User user) {
		this.restTemplate
		.postForEntity(this.KAFKA_SERVICE_URL + "?topicName=userDetail", user, Boolean.class);
		return false;
	}
}
