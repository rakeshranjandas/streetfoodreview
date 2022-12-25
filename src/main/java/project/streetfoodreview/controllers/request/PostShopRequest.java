package project.streetfoodreview.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.streetfoodreview.enums.Rating;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostShopRequest {
    private String name;
    private String location;
}
