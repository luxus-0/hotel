package hotel_app.hotel.repository;

import hotel_app.hotel.entity.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationDateRepository extends JpaRepository<ReservationDate,Long> {

    @Query("SELECT b FROM ReservationDate b WHERE b.checkInDate = ?1")
    List<ReservationDate> findByCheckInDate(LocalDate checkInDate);

    @Query("SELECT b FROM ReservationDate b WHERE b.lateCheckOut = :lateCheckOut")
    boolean findByLateCheckOutDate(boolean lateCheckOut);

    @Query("SELECT b FROM ReservationDate b WHERE b.estimatedCheckInTime = :estimatedCheckInTime")
    LocalTime findByEstimatedCheckInTime(LocalTime estimatedCheckInTime);

    @Query("SELECT b FROM ReservationDate b WHERE b.estimatedCheckOutTime = :estimatedCheckOutTime")
    LocalTime findByEstimatedCheckOutTime(LocalTime estimatedCheckOutTime);

    @Query("SELECT b FROM ReservationDate b WHERE b.policyAcknowledged = :policyAcknowledged")
    boolean findByPolicyAcknowledge(boolean policyAcknowledged);


}
