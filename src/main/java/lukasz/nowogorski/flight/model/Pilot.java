package lukasz.nowogorski.flight.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

public class Pilot extends Passenger {

    @Id
    private Long idPilot;
    private String licencePilot;
    private LocalDate employmentDate;
    private Integer experience;
    private Integer numbersOfFlight;
    private AircraftTypeRegional aircraftTypeRegional;
    private AircraftTypeInternational aircraftTypeInternational;
    private ControlTower controlTowerPermission;
    
}
