package com.theironyard.Controllers;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Tag;
import com.theironyard.Repositories.CoffeeRepository;
import com.theironyard.Repositories.TagRepository;
import com.theironyard.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by darionmoore on 2/7/17.
 */
@Controller
public class SearchController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    TagRepository tagRepository;

    /**
     * gets search results
     * @param model
     * @param session
     * @param search
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String getSearch(Model model, HttpSession session, String search){
        List<Coffee> searchResults = coffeeRepository.findByNameContainingIgnoreCase(search);
        if(searchResults.size() == 0){
            return "redirect:/coffee-not-found";
        }
        model.addAttribute("search", searchResults);
        return "search-result";
    }

    /**
     * FINISH THIS METHOD
     * Supposed to let a user filter coffee by tags
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(path = "/filter-by-tag", method = RequestMethod.GET)
    public String getTagSearch(Model model, HttpSession session, String description){
        Tag filterByTag = tagRepository.findByDescription(description);
        model.addAttribute("filter", filterByTag);
        return "redirect:/coffee-list?tag=" + description;
    }

}
