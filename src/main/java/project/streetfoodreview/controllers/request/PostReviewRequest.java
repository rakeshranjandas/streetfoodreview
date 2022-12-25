package project.streetfoodreview.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.streetfoodreview.enums.Rating;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostReviewRequest {
    private String description;
    private Rating rating;
    private Long shopId;
}
