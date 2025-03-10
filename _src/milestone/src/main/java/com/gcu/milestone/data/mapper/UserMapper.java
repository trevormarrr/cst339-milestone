package com.gcu.milestone.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.milestone.model.RegistrationModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<RegistrationModel> {
    @Override
    public RegistrationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Create new RegistrationModel object
        RegistrationModel user = new RegistrationModel();
        // Set values from rs to RegistrationModel
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
