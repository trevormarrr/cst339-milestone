package com.gcu.milestone.controllers;

// This is the section Ashley started doing
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.milestone.models.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/enter")
public class LoginController {

    @PostMapping("/doEnter")
    public String doLogin(@Valid User user, BindingResult bindingResult, Model model) {
        // User from models packet
        List<User> users = new ArrayList<User>();
        users.add(new User("ashley123", "one", "Ashley", "Barron", "ashley123@gmail.com", "123-456-7890"));
        users.add(new User("trevor123", "one", "Trevor", "Marr", "trevor123@gmail.com", "123-456-7890"));

        if (bindingResult.hasErrors()) {
            return "login";
        }

        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return "redrect:/index";

            }

        }

        model.addAttribute("loginError", "Invalid isername or password");
        return "index";

    }

}
