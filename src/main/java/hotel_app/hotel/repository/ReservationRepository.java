package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r WHERE r.createdDate = ?1")
    List<LocalDate> findByCreatedDate(LocalDate createdDate);

    @Query("SELECT r FROM Reservation r WHERE r.numberChildren = ?1")
    List<Integer> findByNumberChildren(Integer createdDate);

    @Query("SELECT r FROM Reservation r WHERE r.numberAdult = ?1")
    List<Integer> findByNumberAdult(Integer numberAdult);

    @Query("SELECT r FROM Reservation r WHERE r.numberBed = ?1")
    List<Integer> findByNumberBed(Integer numberBed);

    @Modifying
    @Query(
            value ="INSERT INTO Reservation(createdDate, numberChildren, numberAdult, numberBed, password) " +
                    "VALUES (:createdDate, :numberChildren, :numberAdult, :numberBed, :password)",
            nativeQuery = true
    )
    void insertReservation();

    @Modifying
    @Query(value = "update Reservation r set r.id = ?1 where r.id = ?1")
    void updateById(Long id);

    @Modifying
    @Query(value = "update Reservation r set r.createdDate = ?1 where r.createdDate = ?1")
    void updateByCreatedDate(LocalDate createdDate);

    @Modifying
    @Query(value = "update Reservation r set r.numberChildren = ?1 where r.numberChildren = ?1")
    void updateByNumberChildren(Integer numberChildren);

    @Modifying
    @Query(value = "update Reservation r set r.numberAdult = ?1 where r.numberAdult = ?1")
    void updateByNumberAdult(Integer numberAdult);

    @Modifying
    @Query(value = "update Reservation r set r.numberBed = ?1 where r.numberBed = ?1")
    void updateByNumberBed(Integer numberBed);


    @Modifying
    @Query("delete From Reservation r  where r.createdDate = ?1")
    void deleteByCreatedDate(LocalDate createdDate);

    @Modifying
    @Query("delete From Reservation r  where r.numberChildren = ?1")
    void deleteByNumberChildren(Integer numberChildren);

    @Modifying
    @Query("delete From Reservation r  where r.numberAdult = ?1")
    void deleteByNumberAdult(Integer numberAdult);

    @Modifying
    @Query("delete From Reservation r  where r.numberBed = ?1")
    void deleteByNumberBed(Integer numberBed);


}
