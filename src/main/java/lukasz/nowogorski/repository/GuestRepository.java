package lukasz.nowogorski.repository;

import lukasz.nowogorski.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    @Query("SELECT g FROM Guest g WHERE g.name = ?1 AND g.surname = ?2")
    Guest findGuestByNameAndSurname(String name, String surname);

    @Modifying
    @Query(value = "UPDATE Guest g set g.id = ?1 where g.id = ?1")
    Guest updateGuest(Guest guest,Long id);



}
