package lukasz.nowogorski.domain.model;

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
    private Long roomNumber;
    private Long floor;
    private Integer beds;
    private Integer peopleNumber;
    private Float priceForNight;
    private String status;
    private RoomType roomType;

    @OneToOne
    private Reservation reservation;


}
