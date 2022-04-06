package ru.timuraev.spring_boot.PP_3_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.timuraev.spring_boot.PP_3_SpringBoot.model.User;
import ru.timuraev.spring_boot.PP_3_SpringBoot.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("user-create")
    public String newPerson(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findByID(id));
        return "update_user";
    }

    @PostMapping("{id}")
    public String userUpdate(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteByID(id);
        return "redirect:/";
    }
}
