package hotel_app.hotel.Repository;

import hotel_app.hotel.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
