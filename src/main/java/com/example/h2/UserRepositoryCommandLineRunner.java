package com.example.h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.h2.user.User;
import com.example.h2.user.UserRepository;

public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) {
		User harry = new User("Harry", "Admin");
		userRepository.save(harry);
		LOG.info("-------------------------------");
		LOG.info("Finding all users");
		LOG.info("-------------------------------");
		for (User user : userRepository.findAll()) {
			LOG.info(user.toString());
		}
	}
}
