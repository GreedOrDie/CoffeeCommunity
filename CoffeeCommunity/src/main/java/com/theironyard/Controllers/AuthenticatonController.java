package com.theironyard.Controllers;

import com.theironyard.Command.UserCommand;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.UserRepository;
import com.theironyard.Utilities.PassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by darionmoore on 1/26/17.
 */
@Controller
public class AuthenticatonController {
    public static final String CURRENT_USER = "username";

    @Autowired
    UserRepository userRepository;

    /**
     * Gets the registration page
     * @param session
     * @return
     */
    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public String getRegistration(HttpSession session, Model model){
        return "registration";
    }


    /**
     * Facilitates user registration, and verifies whether or not the user exists
     * @param session
     * @param command
     * @return
     * @throws PassHash.CannotPerformOperationException
     * @throws PassHash.InvalidHashException
     */
    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String register(HttpSession session, UserCommand command) throws PassHash.CannotPerformOperationException, PassHash.InvalidHashException {
        User user = userRepository.findFirstByUsername(command.getUsername());
        if(user == null){
            user = new User(command.getName(), command.getEmail(), command.getPhone(), command.getUsername(), PassHash.createHash(command.getPassword()));
            userRepository.save(user);
        } else if(!PassHash.verifyPassword(command.getPassword(), user.getPassword())){
            return "redirect:/";
        }
        session.setAttribute(CURRENT_USER, user.getUsername());
        return "redirect:/user-account";
    }

    /**
     * Gets the login page
     * @param session
     * @return
     */
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLogin(HttpSession session, Model model){
        return "registration";
    }

    /**
     * Allows the user to login,
     * checks if the user exists
     * if the user doesn't, redirects
     * to the registration page
     * if the user does exist,
     * redirects to the community page
     * @param session
     * @param command
     * @return
     * @throws PassHash.InvalidHashException
     * @throws PassHash.CannotPerformOperationException
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, UserCommand command) throws PassHash.InvalidHashException, PassHash.CannotPerformOperationException {
        User user = userRepository.findFirstByUsername(command.getUsername());
//        if(user.isActive(false)){
//            return "redirect:/inactive-user";
//        } else
//
        if(user != userRepository.findFirstByUsername(command.getUsername())){
            return "verification-error";
        } else if(!PassHash.verifyPassword(command.getPassword(), user.getPassword())){
            return "verification-error";
        }
        session.setAttribute(CURRENT_USER, command.getUsername());
        return "redirect:/user-account";
    }


    /**
     * Gets the logout Post path
     * @param session
     * @return
     */
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String getLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    /**
     * logs the user out
     * and redirects to
     * the community page
     * @param session
     * @return
     */
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
