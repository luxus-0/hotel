package lukasz.nowogorski.flight.model;

import java.time.LocalDate;

public class Pilot extends Passenger {

    private String licencePilot;
    private LocalDate employmentDate;
    private Integer experience;
    private Integer numbersOfFlight;
    private AircraftTypeRegional aircraftTypeRegional;
    private AircraftTypeInternational aircraftTypeInternational;
    private ControlTower controlTowerPermission;
    
}
