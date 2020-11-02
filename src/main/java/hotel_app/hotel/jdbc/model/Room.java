package hotel_app.hotel.jdbc.model;

import hotel_app.hotel.entity.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {


    private Long id;
    private Integer beds;
    private Double price;
    private Boolean available;
    private Integer personNumber;
    private RoomType roomType;
    private Double priceForNight;

    public Double getPriceForNight() {

        Logger log = LoggerFactory.getLogger(Room.class);

        Reservation reservation = new Reservation();
        double priceOneNight = roomType.getPriceForRoomType() *
                (reservation.getNumberChildren() + reservation.getNumberChildren());
        log.info("PRICE FOR 1 NIGHT: " + priceOneNight);

        return priceOneNight;
    }


    public double getTotalCostRoom() {
        Logger log = LoggerFactory.getLogger(Room.class);

        Room room = new Room();
        ReservationDate dates = new ReservationDate();
        double totalCost = room.getPriceForNight() * dates.totalDayReservation();
        log.info("TOTAL COST ROOM: " + totalCost);

        return totalCost;

    }
}