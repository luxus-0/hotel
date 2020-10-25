package hotel_app.hotel.repository;

import hotel_app.hotel.entity.BookingDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDateRepository extends JpaRepository<BookingDate,Long> {
}
