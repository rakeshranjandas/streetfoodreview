package project.streetfoodreview.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.streetfoodreview.config.LoggedInUserConfig;
import project.streetfoodreview.controllers.request.PostReviewRequest;
import project.streetfoodreview.entities.Friend;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.enums.FriendshipType;
import project.streetfoodreview.repository.FriendRepository;
import project.streetfoodreview.repository.ReviewRepository;
import project.streetfoodreview.repository.ShopRepository;
import project.streetfoodreview.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final FriendRepository friendRepository;
    private final ShopRepository shopRepository;

    private final LoggedInUserConfig config;


    public User getUserDataFromId(long id) throws Exception {
        log.info("Current logged in user is {}", config.getCurrentLoggedInUser());
        return userRepository.findById(id)
                         .orElseThrow(() -> {
                             log.error("User info not found for id {}", id);
                             return new Exception("User not found");
                         });
    }

    public Review postReview(PostReviewRequest request) {

        var reviewBuilder = Review.builder()
            .description(request.getDescription())
            .rating(request.getRating())
            .userId(Long.parseLong(config.getCurrentLoggedInUser()))
            .shopId(request.getShopId());

        if (request.getId() != null) {
            reviewBuilder.id(request.getId());
        }

        var reviewSaved =  reviewRepository.save(reviewBuilder.build());

        reviewSaved.setShop(shopRepository.findById(request.getShopId()).get());

        return reviewSaved;
    }

    public List<User> getFriendList(long userId) {
        return userRepository.getFriendList(userId);
    }

    @Transactional
    public void updateFriendship(long self, long other, String type) {
        FriendshipType friendshipType;
        try {
             friendshipType = FriendshipType.valueOf(type.toUpperCase());
        } catch (Exception e) {
            log.error("Invalid friendship updation type");
            throw e;
        }

        switch (friendshipType) {
            case FOLLOW:
                log.info("Connecting user {} with user {}", self, other);
                friendRepository.save(Friend.builder()
                        .userId(self)
                        .friendId(other)
                        .build());
                break;

            case UNFOLLOW:
                log.info("Detaching user {} from user {}", self, other);
                long recordsDeleted = friendRepository.deleteByUserIdAndFriendId(self, other);
                log.info("{} records were deleted", recordsDeleted);
                break;
        }
    }

    public List<Review> getReviews(final long id) {
        var allReviewsOfUser = userRepository.findById(id);
        return allReviewsOfUser.get().getReviews();
    }
}
