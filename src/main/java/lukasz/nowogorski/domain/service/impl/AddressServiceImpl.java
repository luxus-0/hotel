package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    @Override
    public Address findAddressById(String id) {

        return null;
    }

    @Override
    public Address findAddressByStreetNumber(String streetNumber) {
        return null;
    }

    @Override
    public Address findAddressByApartmentNumber(String apartmentNumber) {
        return null;
    }

    @Override
    public Address findAddressByPostalCode(String postalCode) {
        return null;
    }

    @Override
    public Address findAddressByCity(String city) {
        return null;
    }

    @Override
    public Address findAddressByCountry(String country) {
        return null;
    }

    @Override
    public Address add(Address address) {
        return null;
    }

    @Override
    public Address update(Address address, Long id) {
        return null;
    }
}
