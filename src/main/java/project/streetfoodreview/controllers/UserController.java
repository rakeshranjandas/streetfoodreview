package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streetfoodreview.controllers.request.PostReviewRequest;
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

    @PostMapping("/review")
    public void postReview(@RequestBody final PostReviewRequest request) {
        userService.postReview(request);
    }

}
