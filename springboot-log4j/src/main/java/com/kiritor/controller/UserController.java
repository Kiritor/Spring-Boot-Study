package com.kiritor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    @RequestMapping(value = "/")
    public String hello() {

        logger.debug("test");
        return "hello";
    }
}
