package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.entities.UserLogin;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    Optional<UserLogin> findByName(String username);

    List<UserLogin> findAllByName(String username);
}
