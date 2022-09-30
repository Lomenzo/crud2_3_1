package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

        List<User> usersList = new ArrayList<>();
        usersList.add(userService.testUserMethod());


        //List<Car> newCarList = (carService.getList((count > cars.size()) ? 5 : count, cars));
        model.addAttribute("users", usersList);
        return "pageUsers";
    }
}
