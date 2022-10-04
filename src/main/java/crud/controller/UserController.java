package crud.controller;

import crud.model.User;
import crud.model.UserForm;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/index")
    public String showAddPersonPage(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "pageUsers";
    }

    @PostMapping(value = "/index")
    public String saveUser(Model model, @ModelAttribute("userForm") UserForm userForm) {
        model.addAttribute("userForm", userForm);
        String name = userForm.getName();
        String lastName = userForm.getLastName();
        int salary = userForm.getSalary();
        User newUser = new User(name,lastName,salary);
        userService.saveUser(newUser);
        //List<UserForm> userFormList = new ArrayList<>();
        //userFormList.add(userForm);
        List<User> usersList = userService.getAllUsersTable();
        //model.addAttribute("userForm", userForm);
        return "pageUsers";
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
