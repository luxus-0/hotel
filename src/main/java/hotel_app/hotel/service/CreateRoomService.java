package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class CreateRoomService {

    private final Logger log = LoggerFactory.getLogger(CreateRoomService.class);
    private final RoomRepository roomRepository;


    public void create(Room room)
    {
        if(room == null)
        {
            log.error("ROOM IS EMPTY");
        }
        else {
            roomRepository.insertRoom(room);

        }
    }
}
