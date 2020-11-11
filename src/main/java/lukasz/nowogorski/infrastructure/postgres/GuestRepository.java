package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    @Query(value = "SELECT * FROM Guest g WHERE g.name = ?"
            ,nativeQuery = true)
    List<Guest> findByName(String name);

    @Query(value = "SELECT * FROM Guest g WHERE g.secondName = ?"
            ,nativeQuery = true)
    List<Guest> findBySecondName(String secondName);

    @Query(value = "SELECT * FROM Guest g WHERE g.surname = ?"
            ,nativeQuery = true)
    List<Guest> findBySurname(String surname);

    @Query(value = "SELECT * FROM Guest g WHERE r.gender = ?"
            ,nativeQuery = true)
    List<Guest> findByGender(Gender gender);

    @Query(value = "SELECT * FROM Guest g WHERE r.pesel = ?"
            ,nativeQuery = true)
    List<Guest> findByPesel(Long pesel);

    @Query(value = "SELECT * FROM Guest g WHERE r.nationality = ?"
            ,nativeQuery = true)
    List<Guest> findByNationality(String nationality);

    @Query(value = "SELECT * FROM Guest g WHERE r.dateOfBirth = ?"
            ,nativeQuery = true)
    List<Guest> findByDateOfBirth(LocalDateTime dateOfBirth);

    @Query(value = "SELECT * FROM Guest g WHERE r.telephone = ?"
            ,nativeQuery = true)
    List<Guest> findByTelephone(String telephone);

    @Query(value = "SELECT * FROM Guest g WHERE r.email = ?"
            ,nativeQuery = true)
    List<Guest> findByEmail(String telephone);


    @Modifying
    @Query(value = "UPDATE Guest g set r.id = ? where r.id = ?",
            nativeQuery = true)
    Guest update(Guest guest,Long id);
}
