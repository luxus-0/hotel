package hotel_app.hotel.service;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
final class ValidateRoomService {

    private final RoomRepository roomRepository;
    private final Logger log = LoggerFactory.getLogger(ValidateRoomService.class);

    public void validRoom() {
        if (roomRepository.findAll() == null) {
            log.info("EMPTY ROOM");
        } else {
            showValidRoom();
        }

    }

    public void showValidRoom() {
        List<Room> id = roomRepository.findAll().stream()
                .filter(room -> room.getId() > 0).collect(Collectors.toList());

        List<Room> beds = roomRepository.findAll().stream()
                .filter(room -> room.getBeds() > 0).collect(Collectors.toList());

        List<Room> personNumbers = roomRepository.findAll().stream()
                .filter(room -> room.getPersonNumber() > 0).collect(Collectors.toList());

        List<Room> pricesForNight = roomRepository.findAll().stream()
                .filter(room -> room.getPriceForNight() > 0).collect(Collectors.toList());

        List<Room> prices = roomRepository.findAll().stream()
                .filter(room -> room.getPrice() > 0).collect(Collectors.toList());

        List<Room> availables = roomRepository.findAll().stream()
                .filter(Room::getAvailable).collect(Collectors.toList());

        List<Room> notAvailables = roomRepository.findAll().stream()
                .filter(room -> !room.getAvailable()).collect(Collectors.toList());

        List<Room> roomTypes = roomRepository.findAll().stream()
                .filter(room -> room.getRoomType() == RoomType.Economy
                        && room.getRoomType() == RoomType.Business
                        && room.getRoomType() == RoomType.EconomyPremium
                        && room.getRoomType() == RoomType.Luxury)
                .collect(Collectors.toList());


        log.info("ID: :" + id);
        log.info("BEDS: " + beds);
        log.info("NUMBER: " + personNumbers);
        log.info("PRICE FOR NIGHT: " + pricesForNight);
        log.info("PRICES: " + prices);
        log.info("AVAILABLE: " + availables);
        log.info("DON'T AVAILABLE: " + notAvailables);
        log.info("ROOM TYPES: " + roomTypes);
    }
}


