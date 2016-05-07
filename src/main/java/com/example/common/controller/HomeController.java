package com.example.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jarvis on 2016. 5. 6..
 */
@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    protected static final String VIEW_NAME_HOMEPAGE = "index";

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showHomePage() {
        log.debug("Rendering homepage.");
        return VIEW_NAME_HOMEPAGE;
    }
}
