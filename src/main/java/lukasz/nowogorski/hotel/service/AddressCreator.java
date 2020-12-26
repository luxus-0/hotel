package lukasz.nowogorski.hotel.service;

import lukasz.nowogorski.hotel.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressCreator {

    public Address saveAddress() {
        return Address.builder()
                .id(1L)
                .city("Miracle")
                .street("Granda")
                .number(2)
                .country("Spain")
                .postal_code("34-123")

                .id(2L)
                .city("Bitka")
                .street("Milka")
                .number(23)
                .country("Belgium")
                .postal_code("27-125")

                .id(3L)
                .city("Mirakuj")
                .street("Bestka")
                .number(24)
                .country("Honduras")
                .postal_code("280-125")
                .build();
        }
}


