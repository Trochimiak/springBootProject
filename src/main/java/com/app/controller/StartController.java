package com.app.controller;

import com.app.model.Student;
import com.app.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/student")
public class StartController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.getAllStudents();

        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateStudent(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Student student = studentService.getStudent(id);
        modelAndView.addObject("studentForm", student);
        modelAndView.setViewName("studentForm");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView modelAndView = new ModelAndView();

        Student student = new Student();
        modelAndView.addObject("studentForm", student);
        modelAndView.setViewName("studentForm");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("studentForm") Student student) {
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
