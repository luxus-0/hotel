package hotel_app.hotel.repository;

import hotel_app.hotel.entity.BookingDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingDateRepository extends JpaRepository<BookingDate,Long> {

    @Query("SELECT b FROM BookingDate b WHERE b.checkInDate = ?1")
    List<BookingDate> findByCheckInDate(LocalDate checkInDate);

    @Query("SELECT b FROM BookingDate b WHERE b.lateCheckOut = :lateCheckOut")
    boolean findByLateCheckOutDate(boolean lateCheckOut);

    @Query("SELECT b FROM BookingDate b WHERE b.estimatedCheckInTime = :estimatedCheckInTime")
    LocalTime findByEstimatedCheckInTime(LocalTime estimatedCheckInTime);

    @Query("SELECT b FROM BookingDate b WHERE b.estimatedCheckOutTime = :estimatedCheckOutTime")
    LocalTime findByEstimatedCheckOutTime(LocalTime estimatedCheckOutTime);

    @Query("SELECT b FROM BookingDate b WHERE b.policyAcknowledged = :policyAcknowledged")
    boolean findByPolicyAcknowledge(boolean policyAcknowledged);


}
