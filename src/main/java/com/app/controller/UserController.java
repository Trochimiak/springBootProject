package com.app.controller;

import com.security.RequestIpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private RequestIpAddress ipAddress;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ipAddress.logIpAddress(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
