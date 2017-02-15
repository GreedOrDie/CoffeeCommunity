package com.theironyard.Controllers;

import com.theironyard.Command.RatingCommand;
import com.theironyard.Command.UserCommand;
import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Tag;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.RatingRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    RatingRepository ratingRepository;

    /**
     * Gets the community/home page
     * @param session
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getCommunityPage(Model model, HttpSession session, UserCommand command, String search){
        User user = userRepository.findFirstByUsername(command.getUsername());
        List coffee = coffeeRepository.findAll();
        Coffee recentCoffee = coffeeRepository.findBySubmitted(LocalDateTime.now());
        ArrayList <Coffee> recCoffee = new ArrayList<>();
//            if (recentCoffee.getSubmitted().isAfter(LocalDateTime.now().minusDays(3))) {
//                recCoffee.add(recentCoffee);
//            } else if (recentCoffee.getSubmitted().isAfter(LocalDateTime.now().minusDays(3))) {
//                recCoffee.remove(recentCoffee);
//            }
        model.addAttribute("user", user);
        model.addAttribute("coffee", coffee);
        model.addAttribute("recent", recentCoffee);
        model.addAttribute("recommend", recCoffee);
        session.setAttribute(CURRENT_USER, user);
        return "community-page";
    }

    /**
     * Sets the session attribute to the logged in user
     * @param session
     * @param command
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String CommunityPage(HttpSession session, UserCommand command){
        User user = userRepository.findFirstByUsername(command.getUsername());
        session.setAttribute(CURRENT_USER, user);
        return "redirect:/";
    }

    /**
     * Gets the current users account page
     * @param session
     * @return
     */
    @RequestMapping(path = "/user-account", method = RequestMethod.GET)
    public String getUserAccount(Model model, HttpSession session, User user){
        if(session.getAttribute(CURRENT_USER) == null){
            return "redirect:/user-exception";
        }
        User userId = userRepository.findFirstByUsername((String)session.getAttribute(CURRENT_USER));
        model.addAttribute("preferences", userId.getPreferredCoffee());
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
     * Gets a specific coffee and its information based on the ID of said coffee
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(path = "/coffee", method = RequestMethod.GET)
    public String getCoffee(Model model, HttpSession session, int id){
        Coffee coffee = coffeeRepository.findOne(id);
        List tags = tagRepository.findAll();
        model.addAttribute("coffee", coffee);
        model.addAttribute("tags", coffee.getTags());
        model.addAttribute("rates", coffee.getRatings());
        return "coffee";
    }

    /**
     * Just in case method
     * @param session
     * @param ratingCommand
     * @param id
     * @return
     */
    @RequestMapping(path = "/coffee", method = RequestMethod.POST)
    public String Coffee(HttpSession session, RatingCommand ratingCommand, int id){
        Coffee coffeeId = coffeeRepository.findOne(id);
        User userId = userRepository.findOne(id);
        return "redirect:/coffee?id="+ id;
    }

    /**
     * Implement pageination for the coffee list
     * Also adds the Coffee object to the coffee-list
     * @param session
     * @param page
     * @return
     */
    @RequestMapping(path = "/coffee-list", method = RequestMethod.GET)
    public String getCoffeeList(Model model, HttpSession session, String tag, @RequestParam(defaultValue = "0") int page){
        List coffee = coffeeRepository.findAll();
        List tags = tagRepository.findAll();
        Page<Coffee> coffees = coffeeRepository.findAll(new PageRequest(page, 10));
        if(tag != null){
            Tag filteredTags = tagRepository.findByDescription(tag);
            coffee = coffeeRepository.findByTags(filteredTags);
        }
        if(coffees.hasPrevious()){
            model.addAttribute("prev", true);
            model.addAttribute("prevPageNum", page - 1);
        }

        if(coffees.hasNext()){
            model.addAttribute("next", true);
            model.addAttribute("nextPageNum", page + 1);
        }

        model.addAttribute("coffee", coffee);
        model.addAttribute("tags", tags);
        model.addAttribute("coffees", coffees);
        return "coffee-list";
    }

    /**
     * Just in case method
     * @param session
     * @return
     */
    @RequestMapping(path = "/coffee-list", method = RequestMethod.POST)
    public String coffeeList(HttpSession session){
        return "coffee-list";
    }

    /**
     * Just in case method
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(path = "/about-us", method = RequestMethod.GET)
    public String getAboutUs(Model model, HttpSession session){
        return "about";
    }

    /**
     * Just in case method
     * @param session
     * @return
     */
    @RequestMapping(path = "/about-us", method = RequestMethod.POST)
    public String AboutUs(HttpSession session){
        return "redirect:/about-us";
    }

}
