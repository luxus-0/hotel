package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class DeleteRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(DeleteRoomService.class);



    public void delete(Room room) {
        roomRepository.delete(room);
        if(roomRepository.findAll().isEmpty())
        {
            log.info("DELETE ROOM: ");
        }
        else
        {
            log.error("DON'T DELETE ROOM");
        }

    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);


        if(roomRepository.findById(id).isEmpty())
        {
            log.info("DELETE ROOM: ");
        }
        else
        {
            log.error("DON'T DELETE ROOM");
        }
    }

    public void deleteByBeds(Integer beds)
    {
        log.info("DELETE ROOM BY BEDS");

        roomRepository.deleteByBeds(beds);
    }


   public void deleteByPersonNumber(Integer personNumber)
    {
        log.info("DELETE ROOM BY PERSON NUMBER");

        roomRepository.deleteByPersonNumber(personNumber);
    }

    public void deleteByPriceForNight(Double priceForNight)
    {
        log.info("DELETE ROOM BY PRICE FOR 1 NIGHT");

        roomRepository.deleteByPriceForNight(priceForNight);
    }

   public void deleteByPrice(Double price)
    {
        log.info("DELETE ROOM BY ALL PRICE");

        roomRepository.deleteByPrice(price);
    }


    public void deleteByAvailable(boolean available)
    {
        log.info("DELETE ROOM BY AVAILABLE");

        roomRepository.deleteByAvailable(available);
    }


}
