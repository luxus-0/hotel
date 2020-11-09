package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;

public interface AddressService {

    Address findAddressById(String id);
    Address findAddressByStreetNumber(String streetNumber);
    Address findAddressByApartmentNumber(String apartmentNumber);
    Address findAddressByPostalCode(String postalCode);
    Address findAddressByCity(String city);
    Address findAddressByCountry(String country);

    Address add(Address address);

    Address update(Address address,Long id);

}
