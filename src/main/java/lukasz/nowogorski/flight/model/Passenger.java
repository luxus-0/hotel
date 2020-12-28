package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lukasz.nowogorski.hotel.model.Address;
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
    private String mobile;
    private Gender gender;
    private Long pesel;
    private String email;
    @OneToOne
    private Seat seat;
    @OneToOne
    private Address addressPassenger;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name="name_pilot",
                    referencedColumnName="name",
                    foreignKey = @ForeignKey(name = "fk_name_pilot")),

            @JoinColumn(
                    name="surname_pilot",
                    referencedColumnName="surname",
                    foreignKey = @ForeignKey(name = "fk_surname_pilot"))

    })
    private Pilot pilot;
}
