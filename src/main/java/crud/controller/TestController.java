package crud.controller;

import crud.model.User;
import crud.model.UserForm;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {

    final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String testGetMethod(Model model, ModelMap modelMap) {
        model.addAttribute("userFormer", new UserForm());
        List<User> usersList = userService.getAllUsersTable();
        modelMap.addAttribute("users", usersList);
        return "testPage";
    }

    @PostMapping(value = "/test")
    public String testPostMethod(Model model, @ModelAttribute("userFormer") UserForm userForm, ModelMap modelMap) {
        model.addAttribute("userFormer", userForm);
        String name = userForm.getName();
        String lastName = userForm.getLastName();
        int salary = userForm.getSalary();
        User newUser = new User(name,lastName,salary);
        userService.saveUser(newUser);
        List<User> usersList = userService.getAllUsersTable();
        modelMap.addAttribute("users", usersList);
        return "testPage";
    }

//    @GetMapping(value = "/userlist")
//    public String postUsers(ModelMap model) {
//        List<User> usersList = userService.getAllUsersTable();
//        model.addAttribute("users", usersList);
//        return "testUserpage";
//    }
}
