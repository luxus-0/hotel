package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPilot;
    private String name;
    private String surname;
    private String licencePilot;
    private LocalDate employmentDate;
    private Integer experience;
    private Integer numbersOfFlight;
    @OneToOne
    private ControlTower controlTower;
    @OneToMany(mappedBy = "pilot")
    private List<Passenger> passengers;
}
