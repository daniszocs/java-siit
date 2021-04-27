package org.sci.finalproj;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.sci.finalproj.model.User;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class DogeRulzApplication implements CommandLineRunner {
	@Autowired // injects it here
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DogeRulzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		actualRun();
	}

	private void actualRun(){
		//String name, String userName, String password, Date dateOfBirth
		Date user1Birth = new Date(Calendar.getInstance().getTime().getTime());

		User user1 = new User("Iulia", "Sugah", "abcde", user1Birth);
		User user2 = new User("Iulia2", "Sugah2", "abcde", user1Birth);
		User user3 = new User("Iulia3", "Sugah3", "abcde", user1Birth);

		userService.register(user1);
		userService.register(user2);
		userService.register(user3);

		User testUser = new User();
		testUser.setUserName("Sugah");
		testUser.setPassword("abcde");
		System.out.println("Testing user login " + userService.login(testUser));

	}
}
