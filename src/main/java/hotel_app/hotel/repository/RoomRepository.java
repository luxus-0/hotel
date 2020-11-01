package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>
{
        @Query("SELECT r FROM Room r")
        List<Room> findAll();

        @Query("SELECT r FROM Room r WHERE r.id = ?1")
        List<Room> findById();

        @Query("SELECT r FROM Room r WHERE r.beds = ?1")
        List<Room> findByBeds(Integer beds);

        @Query("SELECT r FROM Room r WHERE r.personNumber = ?1")
        List<Room> findByPersonNumber(Integer personNumber);

        @Query("SELECT r FROM Room r WHERE r.priceForNight = ?1")
        List<Room>findByPriceForNight(Double priceForNight);

    @Query("SELECT r FROM Room r WHERE r.price = ?1")
    List<Room>findByPrice(Double price);

        @Query("SELECT r FROM Room r WHERE r.available = ?1")
        List<Room> findByAvailable(Boolean available);

    @Modifying
    @Query(
                value ="INSERT INTO Room(beds, price,roomType, available) " +
                "VALUES (:beds, :price, :roomType, :available)",
                 nativeQuery = true
            )
    void insertRoom(Room room);

    @Modifying
    @Query(value = "update Room r set r.id = ?1 where r.id = ?1")
    Room updateById(Long id);

   @Modifying
    @Query(value = "update Room r set r.beds = ?1 where r.beds = ?1")
    int updateByBeds(Integer beds);

    @Modifying
    @Query(value = "update Room r set r.personNumber = ?1 where r.personNumber = ?1")
    int updateByPersonNumber(Integer personNumber);

    @Modifying
    @Query(value = "update Room r set r.priceForNight = ?1 where r.priceForNight = ?1")
    double updateByPriceForNight(Double priceForNight);

    @Modifying
    @Query(value = "update Room r set r.price = ?1 where r.price = ?1")
    double updateByPrice(Double price);

    @Modifying
    @Query(value = "update Room r set r.available = ?1 where r.available = ?1")
    boolean updateByAvailable(boolean available);


   @Modifying
    @Query("delete From Room r  where r.beds = ?1")
    void deleteByBeds(Integer beds);

    @Modifying
    @Query("delete From Room r  where r.personNumber = ?1")
    void deleteByPersonNumber(Integer personNumber);

    @Modifying
    @Query("delete From Room r  where r.priceForNight = ?1")
    void deleteByPriceForNight(Double priceForNight);

    @Modifying
    @Query("delete From Room r  where r.price = ?1")
    void deleteByPrice(Double price);

    @Modifying
    @Query("delete From Room r  where r.available = ?1")
    void deleteByAvailable(boolean available);


}
