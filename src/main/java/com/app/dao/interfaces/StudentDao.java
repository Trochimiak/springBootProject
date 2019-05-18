package com.app.dao.interfaces;

import com.app.model.Student;
import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();
    Student getStudent(Long id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
