package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class SearchHotelService {

    public Hotel searchHotel(Hotel hotel)
    {
        return Hotel.builder()
                .address(hotel.getAddress())
                .build();
    }
}
