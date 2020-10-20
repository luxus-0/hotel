package hotel_app.hotel.Repository;

import hotel_app.hotel.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>
{

}
