package project.streetfoodreview.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.streetfoodreview.enums.Rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private Long id;
    private String description;
    private Rating rating;
    @Column(name="user_id")
    private Long userId;
    @Column(name="shop_id")
    private Long shopId;
}
