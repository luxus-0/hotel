package hotel_app.hotel.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private LocalDate createdDate;
    private  Integer numberChildren;
    private  Integer numberAdult;
    private  Integer numberBed;
    private String password;

    @OneToOne
    private Hotel hotel;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Room room;

    @OneToOne
    private Extra extra;

    @OneToOne
    private ReservationDate date;

}
