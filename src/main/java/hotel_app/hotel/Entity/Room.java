package hotel_app.hotel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Room {

    @Id
    private Long id;
    private Integer beds;
    private Integer personNumber;
    private String price;
    private Boolean avalaible;

    @OneToOne
    private Booking booking;



}