package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.ReservationHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationHotelRepository extends JpaRepository<ReservationHotel,Long> {
}
