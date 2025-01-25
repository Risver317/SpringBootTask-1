package project.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.springboot.model.User;
import project.springboot.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.readAllUser());
        return "allUsers";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "formUser";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user) {
        userService.createUser(user);
        return "redirect:/users";
    }


    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "changeUser";
    }


    @PostMapping("/edit")
    public String updateUser(@Valid User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }


    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }


    @GetMapping("/find")
    public String findUserById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "user";
    }
}
