package project.streetfoodreview.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.streetfoodreview.config.LoggedInUserConfig;
import project.streetfoodreview.controllers.request.PostReviewRequest;
import project.streetfoodreview.controllers.response.UserIdentityResponse;
import project.streetfoodreview.entities.Friend;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.entities.UserLogin;
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

    private long setReferenceUserId(long userId) throws Exception{
        if (userId > 0)
            return userId;

        return getPrincipalId();
    }

    private long getPrincipalId() throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext.getAuthentication() == null)
            throw new UserPrincipalNotFoundException("Prinicipal not found.");

        var principal = (UserLogin) securityContext.getAuthentication().getPrincipal();

        return principal.getId();
    }

    public UserIdentityResponse getUserDataFromId(long id) throws Exception {

        id = setReferenceUserId(id);

        var userData= userRepository.findById(id).get();
        var userIdentity = UserIdentityResponse.builder()
                .name(userData.getName())
                .email(userData.getEmail())
                .build();

        return userIdentity;
    }

    public Review postReview(PostReviewRequest request) throws Exception {

        var reviewBuilder = Review.builder()
            .description(request.getDescription())
            .rating(request.getRating())
            .userId(getPrincipalId())
            .shopId(request.getShopId());

        if (request.getId() != null) {
            reviewBuilder.id(request.getId());
        }

        var reviewSaved =  reviewRepository.save(reviewBuilder.build());

        reviewSaved.setShop(shopRepository.findById(request.getShopId()).get());

        return reviewSaved;
    }

    public List<User> getFriendList(long userId) throws Exception  {

        userId = setReferenceUserId(userId);

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

    public List<Review> getReviews(long id) throws Exception {

        id = setReferenceUserId(id);

        var allReviewsOfUser = userRepository.findById(id);
        var reviewsList = allReviewsOfUser.get().getReviews();
        Collections.sort(reviewsList, (a, b) -> Long.compare(b.getId(), a.getId()));

        return reviewsList;
    }
}
