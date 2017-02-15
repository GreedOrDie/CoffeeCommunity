package com.theironyard.Controllers;

import com.theironyard.Command.CoffeeCommand;
import com.theironyard.Command.TagCommand;
import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Tag;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by darionmoore on 1/27/17.
 */
@Controller
public class CreationController {
    public static final String CURRENT_USER = "username";

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    TagRepository tagRepository;

    /**
     * Gets the add coffee page
     * @param session
     * @return
     */
    @RequestMapping(path = "/add-coffee", method = RequestMethod.GET)
    public String getAddCoffee(HttpSession session) {
        return "add-coffee";
    }

    /**
     * Allows coffee to be added, checks if the coffee
     * being added is already in the database according to the name
     * if it does, throws exception, if it doesn't, saves it to the database
     * Checks if someone is logged in, if someone isn't logged in, throws an exception
     * After all, this isn't Wikipedia.
     *
     * @param session
     * @param command
     * @return
     */
    @RequestMapping(path = "/add-coffee", method = RequestMethod.POST)
    public String addCoffee(HttpSession session, CoffeeCommand command) {
        Coffee coffee = coffeeRepository.findFirstByName(command.getName());
        Coffee newCoffee = new Coffee(command.getName(), command.getDescription(), command.getPrice(), command.getManufacturer(), command.getSubmitted());
        if (session.getAttribute(CURRENT_USER) == null) {
            return "redirect:/user-exception";
        } else if (newCoffee != coffeeRepository.findFirstByName(command.getName())) {
            coffeeRepository.save(newCoffee);
        }
        return "redirect:/coffee-list";
    }

    /**
     * Gets the page for adding tags to coffee
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(path = "/create-tag", method = RequestMethod.GET)
    public String getTag(Model model, HttpSession session) {
        return "coffee-tag";
    }

    /**
     * creates a tag for each individual
     * coffee and saves them
     * @param session
     * @param command
     * @return
     */
    @RequestMapping(path = "/create-tag", method = RequestMethod.POST)
    public String createTag(HttpSession session, TagCommand command, int id) {
        Coffee coffee = coffeeRepository.findOne(id);
        if (session.getAttribute(CURRENT_USER) == null) {
            return "redirect:/user-exception";
        }
        Tag newTag = new Tag(command.getDescription());
        newTag.getCoffeeList().add(coffee);
        tagRepository.save(newTag);
        coffee.getTags().add(newTag);
        coffeeRepository.save(coffee);
        return "redirect:/coffee?id="+ id;


    }


    /**
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/add-preference", method = RequestMethod.GET)
    public String getPreferenceList(HttpSession session, Model model){
        return "redirect:/add-preference";
    }

    /**
     * FINISH THIS METHOD
     * @param session
     * @return
     */
    @RequestMapping(path = "/add-preference", method = RequestMethod.POST)
    public String preferenceList(HttpSession session, int id){
        Coffee coffeeId = coffeeRepository.findOne(id);
        User userId = userRepository.findFirstByUsername((String)session.getAttribute(CURRENT_USER));
        userId.getPreferredCoffee().add(coffeeId);
        coffeeId.getUserPreferee().add(userId);
        userRepository.save(userId);
        coffeeRepository.save(coffeeId);
        return "redirect:/coffee?id=" + id;
    }


}