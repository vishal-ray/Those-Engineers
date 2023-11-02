package com.alpha.ThoseEngineers.controllers.users;

import com.alpha.ThoseEngineers.modules.users.User;
import com.alpha.ThoseEngineers.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    public UserRepository userRepository;
    @PostMapping("/newUser")
    public User newUser(@RequestBody User user)
    {
        userRepository.save(user);
        return  user;
    }
}
