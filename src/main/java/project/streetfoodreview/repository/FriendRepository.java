package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.streetfoodreview.entities.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    long deleteByUserIdAndFriendId(Long userId, Long friendId);
}
