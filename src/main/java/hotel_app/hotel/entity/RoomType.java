package hotel_app.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class RoomType
{
    @Id
    private Long idRoomType;
    private String Standard;
    private Integer numberOfCustomer;
    private double price;
}
