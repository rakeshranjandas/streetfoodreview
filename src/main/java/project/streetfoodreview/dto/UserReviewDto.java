package project.streetfoodreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReviewDto {
    private String description;
    private String rating;
    private Long shopId;
    private String shopName;
}
