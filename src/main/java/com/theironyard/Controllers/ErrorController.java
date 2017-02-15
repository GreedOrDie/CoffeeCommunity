package com.theironyard.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by darionmoore on 1/31/17.
 */

@Controller
public class ErrorController {


    /**
     * Redirects the user to an error page
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/user-exception", method = RequestMethod.GET)
    public String getUserException(HttpSession session, Model model) {
        return "no-user";
    }

    /**
     * ERROR PAGE
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/inactive-user", method = RequestMethod.GET)
    public String getInactiveException(HttpSession session, Model model) {
        return "inactive-user";
    }

    /**
     * ERROR PAGE
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/verification-error", method = RequestMethod.GET)
    public String getVerificationError(HttpSession session, Model model) {
        return "verification-error";
    }

    /**
     * Redirects the user to an error page
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/coffee-exists", method = RequestMethod.GET)
    public String getExistsException(HttpSession session, Model model) {
        return "coffee-exists";
    }


    /**
     * ERROR PAGE
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(path = "/coffee-not-found", method = RequestMethod.GET)
    public String getNotFoundException(HttpSession session, Model model) {
        return "coffee-not-found";
    }
}
