package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Hotel;
import lukasz.nowogorski.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Modifying
    @Query(value = "UPDATE Reservation r SET r.id = ?1 where r.id = ?1")
    Reservation updateReservation(Reservation reservation, Long id);


}
