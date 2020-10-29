package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
final class CreateRoomService {

    private final Logger log = LoggerFactory.getLogger(CreateRoomService.class);
    private final RoomRepository roomRepository;

    public CreateRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createRoom(Room room)
    {
        if(room == null)
        {
            log.error("ROOM IS EMPTY");
        }
        else {
            roomRepository.insertRoom(room.getBeds(), room.getTotalCostRoom(), RoomType.Economy,true);
            roomRepository.insertRoom(room.getBeds(), room.getTotalCostRoom(),RoomType.Business,true);
            roomRepository.insertRoom(room.getBeds(), room.getTotalCostRoom(),RoomType.EconomyPremium,true);
            roomRepository.insertRoom(room.getBeds(), room.getTotalCostRoom(),RoomType.Luxury,true);
        }
    }
}
