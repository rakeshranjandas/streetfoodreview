package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.streetfoodreview.config.LoggedInUserConfig;
import project.streetfoodreview.controllers.request.PostReviewRequest;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.repository.ReviewRepository;
import project.streetfoodreview.repository.UserRepository;


@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final LoggedInUserConfig config;


    public User getUserDataFromId(long id) throws Exception {
        log.info("Current logged in user is {}", config.getCurrentLoggedInUser());
        return userRepository.findById(id)
                         .orElseThrow(() -> {
                             log.error("User info not found for id {}", id);
                             return new Exception("User not found");
                         });
    }

    public void postReview(PostReviewRequest request) {
        reviewRepository.save(Review.builder()
                                    .description(request.getDescription())
                                    .rating(request.getRating())
                                    .userId(Long.parseLong(config.getCurrentLoggedInUser()))
                                    .shopId(request.getShopId())
                                    .build());
    }
}
