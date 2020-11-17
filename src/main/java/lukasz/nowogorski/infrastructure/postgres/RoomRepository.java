package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    @Modifying
    @Query(value = "UPDATE Room room SET room.id = ?1 where room.id = ?1")
    Room updateRoom(Room room, Long id);
}
