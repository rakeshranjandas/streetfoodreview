package project.streetfoodreview.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostReviewRequest {
    private String description;
    private String rating;
    private Long shopId;
    private Long id;
}
