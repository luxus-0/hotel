package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;
import org.springframework.stereotype.Component;

@Component
public class ShowHotelAddress {


    public Address showHotelAddress()
    {
        return Address.builder()
                .id(1L)
                .city("Miracle")
                .street("Granda")
                .number(2)
                .country("Spain")
                .postal_code("34-123")

                .id(2L)
                .city("Bitka")
                .street("milka")
                .number(23)
                .country("jakamoto")
                .postal_code("27-125")

                .id(3L)
                .city("Nigra")
                .street("Bestka")
                .number(24)
                .country("Mirakuj")
                .postal_code("280-125")
                .build();


    }

}
