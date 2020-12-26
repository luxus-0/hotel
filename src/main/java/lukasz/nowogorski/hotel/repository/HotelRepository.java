package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT h FROM Hotel h WHERE h.name = ?1")
    Hotel findHotelByName(String name);

    @Modifying
    @Query(value = "UPDATE Hotel h set h.id = ?1 where h.id = ?1")
    Hotel updateHotel(Hotel hotel, Long id);

    @Query("SELECT h FROM Hotel h WHERE h.address = ?1")
    Hotel findHotelByAddress(String address);
}
