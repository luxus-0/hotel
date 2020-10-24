package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long>
{
    @Query("SELECT r FROM Room r")
        List<Room> findRoom();
}
