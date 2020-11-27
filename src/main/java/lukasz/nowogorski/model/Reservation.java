package lukasz.nowogorski.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime checkIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime earlyCheckIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime lateCheckIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime checkOut;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime lateCheckOut;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
                name = "reservation_guests",
                joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id")
              )
    private final Set<Guest> guests=new HashSet<>();

    @OneToMany(mappedBy = "reservation")
    private final Set<Room> rooms = new HashSet<>();
}
