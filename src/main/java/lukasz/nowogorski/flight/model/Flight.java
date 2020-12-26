package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFlight;
    private String fromCity;
    private String toCity;
    private Boolean oneWay;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private String travelDetails;
}
