package com.app.dao;

import com.app.dao.interfaces.CrudDao;
import com.app.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class StudentDaoImpl implements CrudDao<Student, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAll() {
        String query = "SELECT st FROM com.app.model.Student as st";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Student getById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void add(Student student) {
        entityManager.persist(student);

    }

    @Override
    public void update(Student student) {
        Student updateStudent = getById(student.getId());
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setIndexNumber(student.getIndexNumber());
        entityManager.flush();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
