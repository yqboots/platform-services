package com.yqboots.social.facebook.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController(value = "facebookUserController")
@RequestMapping(value = "/facebook")
public class UserController {
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
