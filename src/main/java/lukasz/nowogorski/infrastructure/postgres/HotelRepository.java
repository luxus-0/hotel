package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query(value = "SELECT * FROM Hotel h WHERE h.checkIn = ?"
            ,nativeQuery = true)
List<Hotel> findByCheckIn(LocalDateTime checkIn);

    @Query(value = "SELECT * FROM Hotel h WHERE h.checkOut = ?"
            ,nativeQuery = true)
    List<Hotel> findByCheckOut(LocalDateTime checkOut);
}
