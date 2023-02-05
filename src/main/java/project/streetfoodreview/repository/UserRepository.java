package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.streetfoodreview.dto.UserReviewDto;
import project.streetfoodreview.entities.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query (value = "select u.* from friend f inner join user u on u.id = f.friend_user_id " +
            "where f.user_id=?1", nativeQuery = true)
    List<User> getFriendList(Long userId);

    @Query (value = "select r.description, r.rating, s.id as shopId , s.name as shopName " +
            "from review r inner join shop s on r.shop_id = s.id where r.user_id =?1", nativeQuery = true)
    List<String> getReviews(Long userId);
}
