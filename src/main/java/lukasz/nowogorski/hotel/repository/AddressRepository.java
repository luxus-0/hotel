package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.AddressHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressHotel,Long> {

    @Query("SELECT a FROM Address a WHERE a.city = ?1 AND a.street = ?2")
    AddressHotel findAddressByCityAndStreet(String city, String street);


    @Modifying
    @Query(value = "UPDATE Address a SET a.id = ?1 WHERE a.id = ?1")
    AddressHotel updateAddress(AddressHotel addressHotel, Long id);


}
