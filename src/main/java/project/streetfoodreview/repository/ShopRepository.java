package project.streetfoodreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.streetfoodreview.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}

