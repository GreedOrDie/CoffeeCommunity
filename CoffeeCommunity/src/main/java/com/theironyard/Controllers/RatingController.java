package com.theironyard.Controllers;

import com.theironyard.Command.RatingCommand;
import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Rating;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.RatingRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by darionmoore on 2/7/17.
 */
@Controller
public class RatingController {
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
     * Allows a logged in user to rate a coffee
     * @param model
     * @param session
     * @param command
     * @param id
     * @return
     */
    @RequestMapping(path = "/rate-coffee", method = RequestMethod.GET)
    public String getRating(Model model, HttpSession session, RatingCommand command, int id){
        int rate = command.getRate();
        Coffee coffeId = coffeeRepository.findOne(id);
        User userId = userRepository.findOne(id);
        model.addAttribute("coffeeId", coffeId);
        model.addAttribute("userId", userId);
        model.addAttribute("rate", rate);
        return "redirect:/rate-coffee";
    }

    /**
     * Saves the users rate to the database and the coffee that was rated
     * @param session
     * @param ratingCommand
     * @param id
     * @return
     */
    @RequestMapping(path = "/rate-coffee", method = RequestMethod.POST)
    public String rating(HttpSession session, RatingCommand ratingCommand, int id){
        Coffee coffeeId = coffeeRepository.findOne(id);
        List<Rating> coffeeRatings = new ArrayList<>();
        User userId = userRepository.findFirstByUsername((String)session.getAttribute(CURRENT_USER));
        if(userId == null){
            return "redirect:/user-exception";
        } else {
            Rating rate = new Rating(ratingCommand.getRate(), coffeeId, userId);
            ratingRepository.save(rate);
            coffeeRatings.add(rate);
        }
        return "redirect:/coffee?id=" + id;
    }
}
