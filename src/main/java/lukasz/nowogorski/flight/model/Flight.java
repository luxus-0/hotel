package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime returnTime;
    @ElementCollection
    private List<Flight> details;
}
