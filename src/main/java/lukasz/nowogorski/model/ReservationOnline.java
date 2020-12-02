package lukasz.nowogorski.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime checkIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime checkOut;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
                name = "reservation_online_guests",
                joinColumns = @JoinColumn(name = "reservationOnline_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id")
              )
    private Set<Guest> guests=new HashSet<>();

    @OneToMany(mappedBy = "reservationOnline")
    private  Set<Room> rooms = new HashSet<>();
}
