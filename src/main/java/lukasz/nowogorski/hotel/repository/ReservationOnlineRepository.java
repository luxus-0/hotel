package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.ReservationOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationOnlineRepository extends JpaRepository<ReservationOnline,Long> {

    @Modifying
    @Query(value = "UPDATE ReservationOnline r SET r.id = ?1 where r.id = ?1")
    ReservationOnline updateReservation(ReservationOnline reservationOnline, Long id);


}
