package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.User;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
