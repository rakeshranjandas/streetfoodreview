package project.streetfoodreview.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "friend_user_id")
    private Long friendId;
}
