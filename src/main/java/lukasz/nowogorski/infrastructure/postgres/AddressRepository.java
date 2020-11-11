package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "SELECT * FROM Address a WHERE a.streetNumber = ?"
            ,nativeQuery = true)
    List<Address> findByStreetNumber(Integer streetNumber);

    @Query(value = "SELECT * FROM Address a WHERE a.apartmentNumber = ?"
            ,nativeQuery = true)
    List<Address> findByApartmentNumber(Integer apartmentNumber);

    @Query(value = "SELECT * FROM Address a WHERE a.postalCode = ?"
            ,nativeQuery = true)
    List<Address> findByPostalCode(String postalCode);

    @Query(value = "SELECT * FROM Address a WHERE a.city = ?"
            ,nativeQuery = true)
    List<Address> findByCity(String city);

    @Query(value = "SELECT * FROM Address a WHERE a.country = ?"
            ,nativeQuery = true)
    List<Address> findByCountry(String country);

    @Modifying
    @Query(value = "UPDATE Address a set a.id = ? where r.id = ?",
            nativeQuery = true)
    Address update(Address address, Long id);




}
