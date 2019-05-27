package com.app.controller;

import com.app.model.Student;
import com.app.service.StudentServiceImpl;
import com.security.RequestIpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StartController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private RequestIpAddress ipAddress;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllStudents(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.getAllStudents();

        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("studentList");
        ipAddress.logIpAddress(request);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView updateStudent(@PathVariable Long id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Student student = studentService.getStudent(id);
        modelAndView.addObject("studentForm", student);
        modelAndView.setViewName("studentForm");
        ipAddress.logIpAddress(request);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addStudent(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Student student = new Student();
        modelAndView.addObject("studentForm", student);
        modelAndView.setViewName("studentForm");
        ipAddress.logIpAddress(request);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("studentForm") Student student, HttpServletRequest request) {
        ipAddress.logIpAddress(request);
        if (student.getId() != null) {
            studentService.updateStudent(student);
        } else {
            studentService.addStudent(student);
        }

        return new ModelAndView("redirect:/student/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);

        return new ModelAndView("redirect:/student/list");
    }
}
