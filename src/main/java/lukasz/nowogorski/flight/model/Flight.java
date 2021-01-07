package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
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

}
