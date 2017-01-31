package com.theironyard.Controllers;

import com.theironyard.Entities.Coffee;
import com.theironyard.Exceptions.NotLoggedInException;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by darionmoore on 1/26/17.
 */
@Controller
public class NavigationController {
    public static final String CURRENT_USER = "username";
    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    TagRepository tagRepository;

    /**
     * Gets the community/home page
     * @param session
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getCommunityPage(Model model, HttpSession session){
        List coffee = coffeeRepository.findAll();
        model.addAttribute("coffee", coffee);
        return "community-page";
    }

    /**
     * FINISH THIS METHOD
     * @param session
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String CommunityPage(HttpSession session){
        return "redirect:/";
    }

    /**
     * Gets the current users account page
     * @param session
     * @return
     */
    @RequestMapping(path = "/user-account", method = RequestMethod.GET)
    public String getUserAccount(HttpSession session){
        if(session.getAttribute(CURRENT_USER) == null){
            throw new NotLoggedInException();
        }
        return "user-account";
    }

    /**
     * Not sure about this yet
     * @param session
     * @return
     */
    @RequestMapping(path = "/user-account", method = RequestMethod.POST)
    public String userAccount(HttpSession session){
        return "user-account";
    }

    /**
     * Gets the current users preference list
     * FINISH WRITING THIS METHOD
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(path = "/user-preferences", method = RequestMethod.GET)
    public String getPrefernces(Model model, HttpSession session){

        return "preference-list";
    }

    /**
     * Allows preferences to be changed
     * FINISH WRITING THIS METHOD
     * @param session
     * @return
     */
    @RequestMapping(path = "/user-preferences", method = RequestMethod.POST)
    public String changePreferences(HttpSession session){
        return "preference-list";
    }



    /**
     * Gets the current users account settings page
     * FINISH THIS METHOD
     * @param session
     * @return
     */
    @RequestMapping(path = "/account-settings", method = RequestMethod.GET)
    public String getAccountSettings(HttpSession session, Model model){
        return "account-settings";
    }

    /**
     * Allows the user to change their account settings
     * FINSIH THIS METHOD
     * @param session
     * @return
     */
    @RequestMapping(path = "/account-settings", method = RequestMethod.POST)
    public String AccountSettings(HttpSession session){
        return "account-settings";
    }

    /**
     * Gets a specific coffee and its information based on the ID of said coffee
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(path = "/coffee/{id}", method = RequestMethod.GET)
    public String getCoffee(Model model, @PathVariable int id){
        Coffee coffee = coffeeRepository.findOne(id);
        List tags = tagRepository.findAll();
        model.addAttribute("coffee", coffee);
        model.addAttribute("tags", tags);
        return "coffee";
    }

}
