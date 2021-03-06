package lukasz.nowogorski.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Guest guest;
    @OneToOne
    private ReservationOnline reservationOnline;
    @ManyToMany
    private Set<Extra> extras;
    @ElementCollection
    private Set<Diet> diets;
}
