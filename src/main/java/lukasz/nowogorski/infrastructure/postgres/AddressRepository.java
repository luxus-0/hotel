package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    Optional<Address> findById(Long id);
    List<Address> findByStreetNumber(String streetNumber);
    List<Address> findByApartmentNumber(String apartmentNumber);
    List<Address> findByPostalCode(String postalCode);
    List<Address> findByCity(String city);
    List<Address> findByCountry(String country);


    Address update(Address address,Long id);
}
