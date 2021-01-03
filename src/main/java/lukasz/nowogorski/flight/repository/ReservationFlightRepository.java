package lukasz.nowogorski.flight.repository;

import lukasz.nowogorski.flight.model.ReservationFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationFlightRepository extends JpaRepository<ReservationFlight,Long> {
}
