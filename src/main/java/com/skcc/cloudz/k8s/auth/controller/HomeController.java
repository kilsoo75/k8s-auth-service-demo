package com.skcc.cloudz.k8s.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skcc.cloudz.k8s.auth.OpenIdConnectUserDetails;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    @ResponseBody
    public final String home() {
//        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        logger.info(username);
        
        OpenIdConnectUserDetails user = (OpenIdConnectUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "User Info ==> " + user;
    }

}