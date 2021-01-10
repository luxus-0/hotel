package lukasz.nowogorski.flight.model;

import lombok.Builder;
import lombok.Data;
import lukasz.nowogorski.hotel.model.AddressHotel;

import javax.persistence.*;

@Entity
@Data
@Builder
public class ControlTower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private Boolean permission;
    private String description;
    private String sendToPilot;
    @OneToOne
    private AddressHotel addressControlTower;
}
