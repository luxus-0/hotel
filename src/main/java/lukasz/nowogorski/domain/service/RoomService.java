package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Room;
import lukasz.nowogorski.domain.model.RoomStandard;
import lukasz.nowogorski.domain.model.RoomType;

import java.util.List;

public interface RoomService {

    List<Room> findRoom();
    Room findRoomById(Long id);
    List<Room> findRoomByRoomNumber(Long roomNumber);
    List<Room> findRoomByFloor(Long floor);
    List<Room> findRoomByBeds(Long beds);
    List<Room> findRoomByPeopleNumber(Long peopleNumber);
    List<Room> findRoomByRoomStandard(RoomStandard roomStandard);
    List<Room> findRoomByPriceForNight(Float priceForNight);
    List<Room> findRoomByRoomType(RoomType roomType);
    List<Room> findRoomByStatus(String status);
    Room saveRoom(Room Room);
    Room updateRoom(Room Room, Long id);
    void deleteRoom();
    void deleteRoomById(Long id);


}
