package com.theironyard;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Tag;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.RatingRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeCommunityApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CoffeeRepository coffeeRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
    RatingRepository ratingRepository;

	@Autowired
	WebApplicationContext wac;

	MockMvc mvc;

	@Before
	public void before(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}


	@Test
	public void testingAddCoffee() throws Exception {
		String testName = "testName";
		String testDesc = "testdesc";
		String testPrice = "1.0";
		String testManu = "testmanu";

        mvc.perform(
				MockMvcRequestBuilders.post("/add-coffee")
				.param("name", testName)
				.param("description", testDesc)
				.param("price", testPrice)
				.param("manufacturer", testManu)
				.sessionAttr("username", "testuser")
		).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

		Coffee coffee = coffeeRepository.findFirstByName(testName);
		assertNotNull(coffee);
    }

	@Test
    public void testAddingTag() throws Exception{
        String testId = "1";
        String testDescription = "testtag";

        mvc.perform(
                MockMvcRequestBuilders.post("/create-tag")
                .param("id", testId)
                .param("tag", testDescription)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        Tag newTag = new Tag(testDescription);
        Tag tag = tagRepository.findByDescription(testDescription);
        tagRepository.save(newTag);
        assertNotNull(newTag);

    }

    @Test
    public void testAddingRate() throws Exception {
        String testId = "1";
        String testRate = "1";
        String testCoffeeId = "1";
        String testUserId = "1";


        mvc.perform(
                MockMvcRequestBuilders.post("/rate-coffee")
                .param("1", testId)
                .param("1", testRate)
                .param("1", testCoffeeId)
                .param("1", testUserId)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

    }


    @Test
    public void testRegistration() throws Exception {
        String testName = "test";
        String testEmail = "test@test.test";
        String testPhone = "123456789";
        String testUser = "test";
        String testPass = "test";


        mvc.perform(
                MockMvcRequestBuilders.post("/registration")
                .param("test", testName)
                .param("test@test.test", testEmail)
                .param("123456789", testPhone)
                .param("test", testUser)
                .param("test", testPass)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
        User user = new User(testName, testEmail, testPhone, testUser, testPass);
        userRepository.save(user);
        assertNotNull(user);

    }

    @Test
    public void testLogin() throws Exception {
        String testUser = "testUser";
        String testPassword = "testPass";

        mvc.perform(
                MockMvcRequestBuilders.post("/login")
                .param("testUser", testUser)
                .param("testPass", testPassword)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        User user = userRepository.findFirstByUsername(testUser);
        assertNotNull(user);
    }


    @Test
    public void testSearch(){}

    @Test
    public void testTagFilter(){}

    @Test
    public void testAddPreference(){}

    @Test
    public void testProfileDeactivate(){}

    @Test
    public void testIfRecent(){}

    @Test
    public void testRecommendation(){}



}
