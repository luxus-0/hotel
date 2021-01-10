package lukasz.nowogorski.flight.model;

import lombok.Builder;
import lombok.Data;
import lukasz.nowogorski.hotel.model.AddressHotel;
import javax.persistence.*;

@Entity
@Data
@Builder
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAirport;
    private String name;
    @OneToOne
    private AddressHotel addressAirport;
}
