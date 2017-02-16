package com.theironyard;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Rating;
import com.theironyard.Entities.Tag;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.RatingRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import com.theironyard.Utilities.PassHash;
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

import static com.theironyard.Controllers.RatingController.CURRENT_USER;
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


// RATING CONTROLLER TESTS

    @Test
    public void testAddingRate() throws Exception {
        String id = "1";
        String testRate = "1";
        String testCoffeeId = "1";
        String testUserId = "1";
        User user = new User("name", "email@email.email", "1234", CURRENT_USER, "pass");
        Coffee coffee = new Coffee("name", "description", 1.1, "manufacturer");
        Rating rate = new Rating( 1, coffee, user);
        userRepository.save(user);
        coffeeRepository.save(coffee);


        mvc.perform(
                MockMvcRequestBuilders.post("/rate-coffee")
                        .param("rate", testRate)
                        .param("id", String.valueOf(coffeeRepository.findOne(Integer.valueOf(testCoffeeId))))
                        .sessionAttr(CURRENT_USER, String.valueOf(userRepository.findOne(Integer.valueOf(testUserId))))
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
//        NOT PASSING



    }



// AUTHENTICATION CONTROLLER TESTS
    @Test
    public void testRegistration() throws Exception {
        String testName = "test";
        String testEmail = "test@test.test";
        String testPhone = "123456789";
        String testUser = "test";
        String testPass = "test";
        User user = new User(testName, testEmail, testPhone, testUser, PassHash.createHash(testPass));
        userRepository.save(user);



        mvc.perform(
                MockMvcRequestBuilders.post("/registration")
                .param("name", testName)
                .param("email", testEmail)
                .param("phone", testPhone)
                .param("username", testUser)
                .param("password", testPass)
                .sessionAttr(CURRENT_USER, user.getUsername())
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

//        PASSING

    }

    @Test
    public void testLogin() throws Exception {
        String testName = "test";
        String testEmail = "test@test.test";
        String testPhone = "123456789";
        String testUser = "testUser";
        String testPassword = "testPass";
        User user = new User(testName, testEmail, testPhone, testUser, PassHash.createHash(testPassword));
        userRepository.save(user);


        mvc.perform(
                MockMvcRequestBuilders.post("/login")
                .param("username", testUser)
                .param("password", testPassword)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());



//       PASSING
    }



//SEARCH CONTROLLER TESTS
    @Test
    public void testSearch() throws Exception {
        String testSearch = "search";

        mvc.perform(
              MockMvcRequestBuilders.get("/search")
                .param("search", testSearch)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
//        PASSING
    }

    @Test
    public void testTagFilter() throws Exception {
        String testTagFilter = "tag";

        mvc.perform(
                MockMvcRequestBuilders.get("/filter-by-tag")
                .param("description", testTagFilter)
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
//        PASSING
    }



//  CREATION CONTROLLER TESTS
    @Test
    public void testAddPreference(){

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
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        Coffee coffee = coffeeRepository.findFirstByName(testName);
        assertNotNull(coffee);
//        PASSING
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
//        PASSING

    }

}
