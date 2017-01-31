package com.theironyard.Controllers;

import com.theironyard.Command.UserCommand;
import com.theironyard.Entities.User;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by darionmoore on 1/30/17.
 */
@Controller
public class DestructionController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/delete-profile", method = RequestMethod.GET)
    public String getDeleteProfile(HttpSession session){
        return "delete-profile";
    }

    @RequestMapping(path = "/delete-profile/{id}", method = RequestMethod.POST)
        public String deleteProfile(Model model, HttpSession session, UserCommand command, @PathVariable int id){
        User deleteUser = userRepository.findOne(id);
        model.addAttribute("delete", deleteUser);

        if(command.getUsername() == deleteUser.getUsername()){
            if(command.getPassword() == deleteUser.getPassword()){
                userRepository.delete(id);
            }
        }
        return "redirect:/";
    }

}
