package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

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

        @Query("SELECT r FROM Room r WHERE r.available = ?1")
        List<Room> findByAvailable(Boolean available);

    @Modifying
    @Query(
                value ="INSERT INTO Room(beds, personNumber, priceForNight, price, available) " +
                "VALUES (:beds, :personNumber, :priceForNight, :price, :available)",
                 nativeQuery = true
            )
       void insertRoom(@Param("beds")Integer beds, @Param("personNumber")Integer personNumber,
                       @Param("priceForNight")Double priceForNight, @Param("price")Double price,
                       @Param("available") Boolean available);

    @Modifying
    @Query(value = "update Room r set r.beds = ? where r.beds = ?",
            nativeQuery = true)
    int updateRoomSetBeds(Integer beds);

    @Modifying
    @Query(value = "update Room r set r.personNumber = ? where r.personNumber = ?",
            nativeQuery = true)
    int updateRoomSetPersonNumber(Integer personNumber);

    @Modifying
    @Query(value = "update Room r set r.priceForNight = ? where r.priceForNight = ?",
            nativeQuery = true)
    double updateRoomSetPriceForNight(Double priceForNight);

    @Modifying
    @Query(value = "update Room r set r.price = ? where r.price = ?",
            nativeQuery = true)
    double updateRoomSetPrice(Double price);

    @Modifying
    @Query(value = "update Room r set r.available = ? where r.available = ?",
            nativeQuery = true)
    boolean updateRoomSetAvailable(boolean available);

    @Modifying
    @Transactional
    @Query("delete From Room r  where r.beds = ?")
    int deleteByBeds(Integer beds);

    @Modifying
    @Transactional
    @Query("delete From Room r  where r.personNumber = ?")
    int deleteByPersonNumber(Integer personNumber);

    @Modifying
    @Transactional
    @Query("delete From Room r  where r.priceForNight = ?")
    double deleteByPriceForNight(Double priceForNight);

    @Modifying
    @Transactional
    @Query("delete From Room r  where r.price = ?")
    double deleteByPrice(Double price);

    @Modifying
    @Transactional
    @Query("delete From Room r  where r.available = ?")
    boolean deleteByAvailable(boolean available);



}
