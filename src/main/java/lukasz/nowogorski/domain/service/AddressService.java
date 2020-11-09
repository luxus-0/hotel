package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<Address> findAddressById(String id);
    List<Address> findAddressByStreetNumber(String streetNumber);
    List<Address> findAddressByApartmentNumber(String apartmentNumber);
    List<Address> findAddressByPostalCode(String postalCode);
    List<Address> findAddressByCity(String city);
    List<Address> findAddressByCountry(String country);

    Address add(Address address);

    Address update(Address address,Long id);

}
