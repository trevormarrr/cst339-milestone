package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.milestone.data.mapper.UserMapper;
import com.gcu.milestone.model.RegistrationModel;

@Repository
public class UserDAOImpl implements DataAccessInterface<RegistrationModel> {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RegistrationModel> findAll() {
        String sql = "SELECT * FROM users";
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<RegistrationModel>();
        }
    }

    @Override
    public RegistrationModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RegistrationModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (Exception e) {
            return null;
        }
    }

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
                user.getPassword()
            );
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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
                user.getUsername()
            );
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(RegistrationModel user) {
        String sql = "DELETE FROM users WHERE username = ?";
        try {
            int rows = jdbcTemplate.update(sql, user.getUsername());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Additional utility method
    public boolean exists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }
}
