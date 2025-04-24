package com.gcu.milestone.data;

import java.util.List;

/**
 * Interface for DAO
 * CRUD operations for any type of entity T
 */
public interface DataAccessInterface<T> {
    // retrieves all records of type T
    public List<T> findAll();

    // retrieves record by id
    public T findById(int id);

    // retrieves record by username
    public T findByUsername(String username);

    // create new record of type T
    public boolean create(T t);

    // updates record of type T
    public boolean update(T t);

    // delete record of type T
    public boolean delete(T t);
}
