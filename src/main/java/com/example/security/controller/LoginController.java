package com.example.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jarvis on 2016. 5. 6..
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    protected static final String VIEW_NAME_LOGIN_PAGE = "user/login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        log.debug("Rendering login page.");
        return VIEW_NAME_LOGIN_PAGE;
    }
}
