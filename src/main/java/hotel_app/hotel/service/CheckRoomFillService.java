package hotel_app.hotel.service;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
final class CheckRoomFillService {

    private final Room room = new Room();
    private final Reservation reservation = new Reservation();
    private final Logger log = LoggerFactory.getLogger(CheckRoomFillService.class);

    public CheckRoomFillService(RoomRepository roomRepository) {
    }

    public boolean isRoomFull()
    {

        log.info("Is room full?");
        boolean full = (reservation.getNumberChildren() + reservation.getNumberAdult())
                >= room.getBeds();

        log.info("Room is full? : : " +full);
        return full;
    }

    public boolean isRoomEmpty()
    {
        log.info("Is room empty?");
        boolean empty = (reservation.getNumberChildren() + reservation.getNumberAdult())
                < room.getBeds();

        log.info("Room is empty? : " +empty);
        return empty;
    }

}
