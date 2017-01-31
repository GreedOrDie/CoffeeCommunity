package com.theironyard;

import com.theironyard.Entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeCommunityApplicationTests {


	/**
	 * Test if a user is created
	 * and saved to the database
	 */
	@Test
	public void createUser(){
		User user = new User();


	}

}
