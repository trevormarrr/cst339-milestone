package com.gcu.milestone.data;

import java.util.List;

/**
 * Generic interface for data access operations
 * @param <T> the type of entity this interface handles
 */
public interface DataAccessInterface<T> {
    /**
     * Retrieves all entities
     * @return List of all entities
     */
    public List<T> findAll();

    /**
     * Finds an entity by its ID
     * @param id the ID to search for
     * @return the found entity or null if not found
     */
    public T findById(int id);

    /**
     * Finds an entity by username
     * @param username the username to search for
     * @return the found entity or null if not found
     */
    public T findByUsername(String username);

    /**
     * Creates a new entity
     * @param t the entity to create
     * @return true if creation was successful
     */
    public boolean create(T t);

    /**
     * Updates an existing entity
     * @param t the entity to update
     * @return true if update was successful
     */
    public boolean update(T t);

    /**
     * Deletes an entity
     * @param t the entity to delete
     * @return true if deletion was successful
     */
    public boolean delete(T t);
}
