package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lukasz.nowogorski.hotel.model.Address;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAirport;
    private String name;
    @OneToOne
    private Address addressAirport;
}
