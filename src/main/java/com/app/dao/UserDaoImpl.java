package com.app.dao;

import com.app.dao.interfaces.CrudDao;
import com.app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class UserDaoImpl implements CrudDao<User, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String query = "SELECT st FROM com.app.model.User as st";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User getById(Long id) {
        //TODO
        return null;
    }

    @Override
    public void add(User object) {
        //TODO
    }

    @Override
    public void update(User object) {
        //TODO
    }

    @Override
    public void delete(Long id) {
        //TODO
    }
}
