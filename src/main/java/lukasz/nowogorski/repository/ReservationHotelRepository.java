package lukasz.nowogorski.repository;

import lukasz.nowogorski.model.ReservationHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationHotelRepository extends JpaRepository<ReservationHotel,Long> {
}
