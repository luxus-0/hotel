package hotel_app.hotel.repository;

import hotel_app.hotel.entity.BookingDate;
import hotel_app.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingDateRepository extends JpaRepository<BookingDate,Long> {

    @Query("SELECT b FROM BookingDate b WHERE b.checkInDate = ?1")
    List<BookingDate> findByCheckInDate(LocalDate checkInDate);
}
