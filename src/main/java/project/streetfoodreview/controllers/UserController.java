package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.streetfoodreview.controllers.request.PostReviewRequest;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.services.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;
    @GetMapping("/{id}")
    public User getUserDataFromId(@PathVariable final long id) throws Exception {
        return userService.getUserDataFromId(id);
    }

    @PostMapping("/review")
    public void postReview(@RequestBody final PostReviewRequest request) {
        userService.postReview(request);
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriendList(@PathVariable("id") final long userId) {
        return userService.getFriendList(userId);
    }
}
