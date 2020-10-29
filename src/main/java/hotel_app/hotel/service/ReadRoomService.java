package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final class ReadRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(ReadRoomService.class);

    public ReadRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void getRoom()
    {
        log.info("FIND ROOM");
        roomRepository.findAll().stream()
                .filter(room -> room.getId() > 0).forEach(System.out::println);
    }

    List<Room> findByBeds(Integer beds){
        log.info("FIND ROOM BY BEDS");

        return roomRepository.findByBeds(beds);
    }

    List<Room> findByPersonNumber(Integer personNumber)
    {
        log.info("FIND ROOM BY PERSON NUMBER");

        return roomRepository.findByPersonNumber(personNumber);
    }

    List<Room>findByPriceForNight(Double priceForNight)
    {
        log.info("FIND ROOM BY PRICE FOR NIGHT");

        return roomRepository.findByPriceForNight(priceForNight);
    }

    List<Room> findByAvailable(Boolean available)
    {
        log.info("FIND ROOM BY AVAILABLE");

        return roomRepository.findByAvailable(available);
    }

}
