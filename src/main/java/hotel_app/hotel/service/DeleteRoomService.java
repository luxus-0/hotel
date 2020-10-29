package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
final class DeleteRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(DeleteRoomService.class);

    public DeleteRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public void deleteRoom() {
        roomRepository.deleteAll();
        if(roomRepository.findAll().isEmpty())
        {
            log.info("DELETE ROOM: ");
        }
        else
        {
            log.error("DON'T DELETE ROOM");
        }

    }

    int deleteByBeds(Integer beds)
    {
        log.info("DELETE ROOM BY BEDS");

        return roomRepository.deleteByBeds(beds);
    }


    int deleteByPersonNumber(Integer personNumber)
    {
        log.info("DELETE ROOM BY PERSON NUMBER");

        return roomRepository.deleteByPersonNumber(personNumber);
    }

    double deleteByPriceForNight(Double priceForNight)
    {
        log.info("DELETE ROOM BY PRICE FOR 1 NIGHT");

        return roomRepository.deleteByPriceForNight(priceForNight);
    }

    double deleteByPrice(Double price)
    {
        log.info("DELETE ROOM BY ALL PRICE");

        return roomRepository.deleteByPrice(price);
    }


    boolean deleteByAvailable(boolean available)
    {
        log.info("DELETE ROOM BY AVAILABLE");

        return roomRepository.deleteByAvailable(available);
    }

}
