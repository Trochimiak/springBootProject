package com.app.dao.interfaces;

import java.util.List;

public interface CrudDao<T, K> {

    List<T> getAll();
    T getById(K id);
    void add(T object);
    void update(T object);
    void delete(K id);
}
