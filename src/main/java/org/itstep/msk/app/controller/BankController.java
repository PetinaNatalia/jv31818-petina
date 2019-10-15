package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class BankController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/{userId}")
    public String user(@PathVariable int userId) {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            String  someUser = user.toString();
            return someUser;
        }  else return "NO";
    }
}

