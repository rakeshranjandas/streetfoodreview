package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.streetfoodreview.entities.Review;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT r.* FROM shop s " +
            "INNER JOIN review r ON s.id = r.shop_id " +
            "WHERE s.id=?1", nativeQuery = true)
    List<Review> getShopReviews(Long shopId);
}
