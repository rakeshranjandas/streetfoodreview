package project.streetfoodreview.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String rating;
    @Column(name="user_id")
    private Long userId;
    @Column(name="shop_id")
    private Long shopId;

    @JsonIgnoreProperties("reviews")
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "shop_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private Shop shop;
}
