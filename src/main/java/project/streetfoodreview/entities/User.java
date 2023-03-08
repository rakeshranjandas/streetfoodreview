package project.streetfoodreview.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private transient String password;

    @OneToMany (
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn (
        name = "user_id",
        referencedColumnName = "id"
    )
    private List<Review> reviews;
}
