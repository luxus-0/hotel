package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Reservation;
import lukasz.nowogorski.domain.model.Room;
import lukasz.nowogorski.domain.model.RoomStandard;
import lukasz.nowogorski.domain.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {


    
    @Query(value = "SELECT * FROM Room r WHERE r.roomNumber = ?"
            ,nativeQuery = true)
    List<Room> findByRoomNumber(Long roomNumber);

    @Query(value = "SELECT * FROM Room r WHERE r.floor = ?"
            ,nativeQuery = true)
    List<Room> findByFloor(Long floor);

    @Query(value = "SELECT * FROM Room r WHERE r.beds = ?"
            ,nativeQuery = true)
    List<Room> findByBeds(Long beds);

    @Query(value = "SELECT * FROM Room r WHERE r.peopleNumber = ?"
            ,nativeQuery = true)
    List<Room> findByPeopleNumber(Long peopleNumber);

    @Query(value = "SELECT * FROM Room r WHERE r.roomStandard = ?"
            ,nativeQuery = true)
    List<Room> findByRoomStandard(RoomStandard roomStandard);

    @Query(value = "SELECT * FROM Room r WHERE r.priceForNight = ?"
            ,nativeQuery = true)
    List<Room> findByPriceForNight(Float priceForNight);

    @Query(value = "SELECT * FROM Room r WHERE r.roomType = ?"
            ,nativeQuery = true)
    List<Room> findByRoomType(RoomType roomType);

    @Query(value = "SELECT * FROM Room r WHERE r.status = ?"
            ,nativeQuery = true)
    List<Room> findByStatus(String status);

    @Modifying
    @Query(value = "UPDATE Room r set r.id = ? where r.id = ?",
            nativeQuery = true)
    Room update(Room room,Long id);

}
