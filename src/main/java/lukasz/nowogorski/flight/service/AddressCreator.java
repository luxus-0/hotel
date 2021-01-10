package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressCreator {

    public Address addressCreator(Address address)
    {
        return Address.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .postal_code(address.getPostal_code())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}
