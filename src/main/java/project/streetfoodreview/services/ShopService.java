package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.streetfoodreview.controllers.request.PostShopRequest;
import project.streetfoodreview.entities.Review;
import project.streetfoodreview.entities.Shop;
import project.streetfoodreview.repository.ReviewRepository;
import project.streetfoodreview.repository.ShopRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ShopService {

    private final ShopRepository shopRepository;
    private final ReviewRepository reviewRepository;

    public Shop getShopDataFromId(long id) throws Exception {
        return shopRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Shop info not found for id {}", id);
                    return new Exception("Shop not found");
                });
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop addShop(PostShopRequest request) {
        return shopRepository.save(Shop.builder()
                .name(request.getName())
                .location(request.getLocation())
                .build());
    }

    public List<Review> getShopReviews(long id) {
        return reviewRepository.getShopReviews(id);
    }
}
