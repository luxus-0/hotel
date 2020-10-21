package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>
{

}
