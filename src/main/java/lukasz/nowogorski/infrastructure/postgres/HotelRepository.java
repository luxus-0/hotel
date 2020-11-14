package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query(value = "SELECT * FROM Hotel h WHERE h.name = ?"
            ,nativeQuery = true)
    List<Hotel> findByName(String name);

    @Query(value = "SELECT * FROM Hotel h WHERE h.stars = ?"
            ,nativeQuery = true)
    List<Hotel> findByNumberStars(Integer stars);

    @Query(value = "SELECT * FROM Hotel h WHERE h.email = ?"
            ,nativeQuery = true)
    List<Hotel> findByEmail(String email);

    @Query(value = "SELECT * FROM Hotel h WHERE h.checkIn = ?"
            ,nativeQuery = true)
    List<Hotel> findByCheckIn(LocalTime checkIn);

    @Query(value = "SELECT * FROM Hotel h WHERE h.checkOut = ?"
            ,nativeQuery = true)
    List<Hotel> findByCheckOut(LocalTime checkOut);

    @Query(value = "SELECT * FROM Hotel h WHERE h.earlyCheckIn = ?"
            ,nativeQuery = true)
    List<Hotel> findByEarlyCheckIn(LocalTime earlyCheckIn);

    @Query(value = "SELECT * FROM Hotel h WHERE h.lateCheckIn = ?"
            ,nativeQuery = true)
    List<Hotel> findByLateCheckIn(LocalTime lateCheckIn);

    @Query(value = "SELECT * FROM Hotel h WHERE h.lateCheckOut = ?"
            ,nativeQuery = true)
    List<Hotel> findByLateCheckOut(LocalTime lateCheckOut);

    @Query(value = "SELECT * FROM Hotel h WHERE h.lateCheckOutFee = ?"
            ,nativeQuery = true)
    List<Hotel> findByLateCheckoutFee(BigDecimal lateCheckOutFee);
}
