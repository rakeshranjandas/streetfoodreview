package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streetfoodreview.controllers.request.PostShopRequest;
import project.streetfoodreview.entities.Shop;
import project.streetfoodreview.services.ShopService;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/shop")
public class ShopController {

    private ShopService shopService;

    @GetMapping("/{id}")
    public Shop getShopDataFromId(@PathVariable final long id) throws Exception {
        return shopService.getShopDataFromId(id);
    }

    @PostMapping
    public void postReview(@RequestBody final PostShopRequest request) {
        shopService.addShop(request);
    }
}
