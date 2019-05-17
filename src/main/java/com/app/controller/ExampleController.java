package com.app.controller;


import com.app.model.Student;
import com.app.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class ExampleController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping()
    public ModelAndView forLoopExample() {
        ModelAndView modelAndView = new ModelAndView();
        StringBuilder studentSizeString = studentService.forLoopExample();

        modelAndView.addObject("studentSizeString", studentSizeString);
        modelAndView.setViewName("startPage");
        return modelAndView;
    }
}
