package lukasz.nowogorski.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer roomNumber;
    private Integer floor;
    private Integer beds;
    private Integer peopleNumber;
    private Float price;
    private String status;
    private RoomType roomType;

    @OneToOne
    private ReservationOnline reservationOnline;


}
