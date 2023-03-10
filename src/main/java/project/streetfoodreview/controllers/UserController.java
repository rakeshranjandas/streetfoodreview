package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.streetfoodreview.controllers.request.PostReviewRequest;
import project.streetfoodreview.controllers.response.UserIdentityResponse;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.services.UserService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserIdentityResponse getUserDataFromId(@PathVariable final long id) throws Exception {
        return userService.getUserDataFromId(id);
    }

    @PostMapping("/review")
    public Review postReview(@RequestBody final PostReviewRequest request) throws Exception {
        return userService.postReview(request);
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriendList(@PathVariable("id") final long userId) throws Exception {
        return userService.getFriendList(userId);
    }

    @PutMapping("/{id1}/friend/{id2}")
    public void updateFriendship(@PathVariable("id1") final long self, @PathVariable("id2") final long other,
                                 @RequestParam String type) {
        userService.updateFriendship(self, other, type);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getReviews(@PathVariable final long id) throws Exception {
        return userService.getReviews(id);
    }
}
