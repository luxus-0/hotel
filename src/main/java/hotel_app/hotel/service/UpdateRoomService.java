package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class UpdateRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(UpdateRoomService.class);


    public void update(Room room,Long id)
    {


        if(room.getId().equals(id)) {

            roomRepository.updateByBeds(room.getBeds());
            roomRepository.updateByPersonNumber(room.getPersonNumber());
            roomRepository.updateByPriceForNight(room.getPriceForNight());
            roomRepository.updateByPrice(room.getPrice());
            roomRepository.updateByAvailable(room.getAvailable());
        }
        roomRepository.save(room);
    }

    public Room updateById(Long id) {
        return roomRepository.updateById(id);
    }

    public int updateByBeds(Integer beds)
    {
        log.info("UPDATE ROOM BY BEDS");

        return roomRepository.updateByBeds(beds);
    }


    public int updateByPersonNumber(Integer personNumber)
    {
        log.info("UPDATE ROOM BY PERSON NUMBER");

        return roomRepository.updateByPersonNumber(personNumber);
    }

    public double updateByPriceForNight(Double priceForNight)
    {
        log.info("UPDATE ROOM BY PRICE FOR 1 NIGHT");

        return roomRepository.updateByPriceForNight(priceForNight);
    }

    public double updateByPrice(Double price)
    {
        log.info("UPDATE ROOM BY ALL PRICE");

        return roomRepository.updateByPrice(price);
    }


    public boolean updateByAvailable(boolean available)
    {
        log.info("UPDATE ROOM BY AVAILABLE");

        return roomRepository.updateByAvailable(available);
    }


}
