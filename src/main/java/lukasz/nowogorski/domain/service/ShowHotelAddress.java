package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.infrastructure.postgres.HotelRepository;
import org.springframework.stereotype.Component;

@Component
public class ShowHotelAddress {

    private HotelRepository repository;

    public Address showHotelAddress()
    {
        return Address.builder()
                .id(1L)
                .city("Miracle")
                .street("Granda")
                .number(2)
                .country("Spain")
                .postal_code("34-123")
                .build();

    }

}
