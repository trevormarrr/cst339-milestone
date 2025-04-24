package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.milestone.data.mapper.UserMapper;
import com.gcu.milestone.model.RegistrationModel;

/**
 * UserDAOImpl
 */
@Repository
public class UserDAOImpl implements DataAccessInterface<RegistrationModel> {

    private JdbcTemplate jdbcTemplate;

    /**
     * constructor
     * 
     * @param dataSource
     */
    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * find all users
     */
    @Override
    public List<RegistrationModel> findAll() {
        String sql = "SELECT * FROM users";
        try {
            return jdbcTemplate.query(sql, new UserMapper()); // retrievs all users
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<RegistrationModel>(); // returns empty list
        }
    }

    /**
     * find user by id
     */
    @Override
    public RegistrationModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id); // retreievs user by ID
        } catch (Exception e) {
            e.printStackTrace();
            return null; // return null if not found
        }
    }

    /**
     * find user by username
     */
    @Override
    public RegistrationModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username); // retrieve user by username
        } catch (Exception e) {
            return null; // return null if not found
        }
    }

    /**
     * create user
     */
    @Override
    public boolean create(RegistrationModel user) {
        String sql = "INSERT INTO users (first_name, last_name, email, phone_number, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplate.update(sql,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getUsername(),
                    user.getPassword());
            return rows > 0; // return true if record is inserted
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false
        }
    }

    /**
     * update user
     */
    @Override
    public boolean update(RegistrationModel user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, phone_number = ?, password = ? WHERE username = ?";
        try {
            int rows = jdbcTemplate.update(sql,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getPassword(),
                    user.getUsername());
            return rows > 0; // return true if record updated
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false
        }
    }

    /**
     * delete user
     */
    @Override
    public boolean delete(RegistrationModel user) {
        String sql = "DELETE FROM users WHERE username = ?";
        try {
            int rows = jdbcTemplate.update(sql, user.getUsername()); // Delete user by username
            return rows > 0; // return true if record deleted
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false
        }
    }

    /**
     * Additional utility method
     * checks if usernme exists in db
     * 
     * @param username username to check
     * @return existing user
     */
    public boolean exists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }
}
