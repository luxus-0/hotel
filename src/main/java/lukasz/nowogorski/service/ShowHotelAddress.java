package lukasz.nowogorski.service;

import lukasz.nowogorski.model.Address;
import org.springframework.stereotype.Service;

@Service
public class ShowHotelAddress {


    public Address getHotelAddress1() {
        return Address.builder()
                .id(1L)
                .city("Miracle")
                .street("Granda")
                .number(2)
                .country("Spain")
                .postal_code("34-123")
                .build();

    }

    public Address getHotelAddress2() {
        return Address.builder()
                .id(2L)
                .city("Bitka")
                .street("Milka")
                .number(23)
                .country("Belgium")
                .postal_code("27-125")
                .build();
    }

    public Address getHotelAddress3() {
        return Address.builder()
                .id(3L)
                .city("Mirakuj")
                .street("Bestka")
                .number(24)
                .country("Honduras")
                .postal_code("280-125")
                .build();
    }

}


