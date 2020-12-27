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
public class ControlTower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private Boolean permission;
    private String description;
    private String sendToPilot;
    @OneToOne
    private Address addressControlTower;
}
