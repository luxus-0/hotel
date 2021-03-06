package lukasz.nowogorski.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
public class ReservationFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservationFlight;
    private LocalDate reservationDate;
    private Long reservationNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "reservation_flight_passenger",
            joinColumns = @JoinColumn(name = "idReservationFlight", referencedColumnName = "idReservationFlight"),
            inverseJoinColumns = @JoinColumn(name = "idPassenger", referencedColumnName = "idPassenger")
    )
    private Set<Passenger> passengers;
}
