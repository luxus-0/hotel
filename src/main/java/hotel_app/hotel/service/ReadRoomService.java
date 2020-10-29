package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public final class ReadRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(ReadRoomService.class);


    public List<Room> find()
    {
        log.info("FIND ROOM");
        return roomRepository.findAll();
    }

    public Room findById(Long id)
    {
        log.info("FIND ROOM BY ID");
        return roomRepository.findById(id).orElse(null);
    }

    List<Room> findByBeds(Integer beds){
        log.info("FIND ROOM BY BEDS");

        return roomRepository.findByBeds(beds);
    }

    public List<Room> findByPersonNumber(Integer personNumber)
    {
        log.info("FIND ROOM BY PERSON NUMBER");

        return roomRepository.findByPersonNumber(personNumber);
    }


    public List<Room>findByPriceForNight(Double priceForNight)
    {
        log.info("FIND ROOM BY PRICE FOR NIGHT");

        return roomRepository.findByPriceForNight(priceForNight);
    }

    public List<Room> findByPrice(Double price)
    {
        log.info("FIND ROOM BY PERSON NUMBER");

        return roomRepository.findByPrice(price);
    }

    public List<Room> findByAvailable(Boolean available)
    {
        log.info("FIND ROOM BY AVAILABLE");

        return roomRepository.findByAvailable(available);
    }

}
