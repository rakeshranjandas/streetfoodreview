package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.streetfoodreview.entities.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query (value = "select u.* from friend f inner join user u on u.id = f.friend_user_id " +
            "where f.user_id=?1", nativeQuery = true)
    List<User> getFriendList(Long userId);

    Optional<User> findByName(String username);

    List<User> findAllByName(String username);
}
