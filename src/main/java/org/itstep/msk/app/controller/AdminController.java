package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin")
    @ResponseBody
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/userform")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }

    @PostMapping("/userform")
    public String add(@ModelAttribute User user) {
        userRepository.save(user);
        userRepository.flush();
        return "redirect:/admin";
    }


    @DeleteMapping("/admin/{userId}")
    @ResponseBody
    public String delete(
            @PathVariable Integer userId,
            HttpServletResponse response
    ) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return "OK";
    }
}
