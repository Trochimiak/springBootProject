package com.app.service;

import com.app.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(Long id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    StringBuilder forLoopExample();
    String switchStatementExample() throws Exception;
}
