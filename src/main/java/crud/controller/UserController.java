package crud.controller;

import crud.model.User;
import crud.model.UserForm;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String postUsers(ModelMap model) {
        List<User> usersList = userService.getAllUsersTable();
        model.addAttribute("users", usersList);
        return "pageUsers";
    }

    @PostMapping(value = "/users")
    public String saveUser(@ModelAttribute UserForm userForm, ModelMap model) {

        String name = userForm.getName();
        String lastName = userForm.getLastName();
        int salary = userForm.getSalary();
        User newUser = new User(name,lastName,salary);
        userService.saveUser(newUser);
        //List<User> usersList = userService.getAllUsersTable();
        model.addAttribute("userForm", userForm);
        return "redirect:/pageUsers";
    }


//    @GetMapping(value = "/users")
//    public String postUsers(ModelMap model) {
//
//        List<User> usersList = new ArrayList<>();
//        User user1 = new User("petrykin", "imka", 5000);
//
//        usersList.add(user1);
//        userService.saveUser(user1);
//
//        usersList.add(userService.testUserMethod(user1));
//        model.addAttribute("users", usersList);
//        return "pageUsers";
//    }


}
