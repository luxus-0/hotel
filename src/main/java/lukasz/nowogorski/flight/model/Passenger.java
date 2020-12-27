package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lukasz.nowogorski.hotel.model.Gender;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPassenger;
    private String name;
    private String surname;
    private String address;
    private String mobile;
    private Gender gender;
    private Long pesel;
    private String email;
}
