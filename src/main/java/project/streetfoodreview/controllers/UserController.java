package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.services.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;
    @GetMapping("/{id}")
    public User getUserDataFromId(@PathVariable final long id) throws Exception {
        return userService.getUserDataFromId(id);
    }

}
