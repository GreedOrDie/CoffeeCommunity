package com.theironyard.Controllers;

import com.theironyard.Entities.User;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by darionmoore on 1/30/17.
 */
@Controller
public class DestructionController {
    public static final String CURRENT_USER = "username";

    @Autowired
    UserRepository userRepository;

    /**
     * Gets the profile deactivate page
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(path = "/deactivate-profile", method = RequestMethod.GET)
    public String getDeactivateProfile(Model model, HttpSession session){
        User user = userRepository.findFirstByUsername(CURRENT_USER);
        model.addAttribute("user", user);
        return "deactivate-profile";
    }

    /**
     * FINISH THIS METHOD
     * Deactivates the users account by setting
     * isActive to false
     * @return
     */
    @RequestMapping(path = "/deactivate-profile", method = RequestMethod.POST)
        public String deactivateProfile(HttpSession session){


        return "/";
    }

}


