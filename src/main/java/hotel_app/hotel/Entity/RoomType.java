package hotel_app.hotel.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

/*--Standard--
* comfort,comfort_extra,comfort_plus,
    comfort_lux,apartament,apartament_comfort,
    apartament_lux,penthouse
* */


@Entity
@Getter
public class RoomType
{
    @Id
    private Long idRoomType;
    private String Standard;
    private Integer numberOfCustomer;
    private double price;
}
