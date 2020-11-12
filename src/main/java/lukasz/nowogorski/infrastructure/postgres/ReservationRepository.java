package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query(value = "SELECT * FROM Reservation r WHERE r.adultNumber = ?"
            ,nativeQuery = true)
    List<Reservation> findByAdultNumber(Integer adultNumber);

    @Query(value = "SELECT * FROM Reservation r WHERE r.childrenNumber = ?"
            ,nativeQuery = true)
    List<Reservation> findByChildrenNumber(Integer childrenNumber);

    @Query(value = "SELECT * FROM Reservation r WHERE r.extraBedNumber = ?"
            ,nativeQuery = true)
    List<Reservation> findByExtraBedNumber(Integer extraBedNumber);

    @Query(value = "SELECT * FROM Reservation r WHERE r.payment = ?"
            ,nativeQuery = true)
    List<Reservation> findByPayment(String payment);

    @Modifying
    @Query(value = "UPDATE Reservation r set r.id = ? where r.id = ?",
            nativeQuery = true)
    Reservation update(Reservation reservation,Long id);

}
