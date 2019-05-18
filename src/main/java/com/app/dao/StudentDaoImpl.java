package com.app.dao;

import com.app.dao.interfaces.StudentDao;
import com.app.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT st FROM com.app.model.Student as st";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Student getStudent(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);

    }

    @Override
    public void updateStudent(Student student) {
        Student updateStudent = getStudent(student.getId());
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        entityManager.flush();
    }

    @Override
    public void deleteStudent(Long id) {
        entityManager.remove(getStudent(id));
    }
}
