package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
