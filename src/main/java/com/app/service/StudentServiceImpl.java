package com.app.service;

import com.app.dao.StudentDaoImpl;
import com.app.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDaoImpl studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Student deleted: " + getStudent(id).toString());
        studentDao.delete(id);
    }

    @Override
    public StringBuilder forLoopExample() {

        StringBuilder stringBuilder = new StringBuilder();
        List<Student> studentList = getAllStudents();
        for (int i = 0; i < studentList.size(); i++) {
            stringBuilder.append("student number ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
        }

        return stringBuilder;
    }

    @Override
    public String switchStatementExample() throws Exception {
        if (getAllStudents().isEmpty()) {
            return "Empty StudentList";
        }

        switch (getAllStudents().size() % 2) {
            case 0:
                return "This is even number";
            case 1:
                return "This is odd number";
            default:
                throw new Exception("Error");
        }
    }
}
