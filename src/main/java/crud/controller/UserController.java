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
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/userApp")
    public String showUserForm(Model model, ModelMap modelMap) {
        model.addAttribute("userFormer", new UserForm());
        List<User> usersList = userService.getAllUsersTable();
        modelMap.addAttribute("users", usersList);
        return "userPage";
    }

    @PostMapping(value = "/userApp")
    public String addUserPostMethod(Model model, @ModelAttribute("userFormer") UserForm userForm, ModelMap modelMap) {
        model.addAttribute("userFormer", userForm);
        String name = userForm.getName();
        String lastName = userForm.getLastName();
        int salary = userForm.getSalary();
        User newUser = new User(name,lastName,salary);
        userService.saveUser(newUser);
        List<User> usersList = userService.getAllUsersTable();
        modelMap.addAttribute("users", usersList);
        return "userPage";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User userFinded = userService.findUserByID(id);
        //        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("userFinded", new UserForm());
        return "updateUserPage";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("userFinded") UserForm userFinded, /*@Valid User user, BindingResult result, */Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "updateUserPage";
//        }
        model.addAttribute("userFinded", userFinded);
        User userForUpdate = new User(userFinded.getName(), userFinded.getLastName(), userFinded.getSalary());
        userForUpdate.setId(id);
        userService.saveUser(userForUpdate);
        return "updateUserPage";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findUserByID(id);
        //        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(user);
        return "deletedUserPage";
    }
}
