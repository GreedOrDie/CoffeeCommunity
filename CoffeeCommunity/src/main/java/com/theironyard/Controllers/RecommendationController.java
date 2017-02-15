package com.theironyard.Controllers;

import com.theironyard.Repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by darionmoore on 1/31/17.
 */
@Controller
public class RecommendationController {

    @Autowired
    CoffeeRepository coffeeRepository;


}
