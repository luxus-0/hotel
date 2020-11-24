package lukasz.nowogorski.service;

import lukasz.nowogorski.model.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomCreatorService {

    public Room createRoomByBeds(Integer beds)
    {
        return Room
                .builder()
                .beds(beds)
                .build();
    }
    public Room createRoomByNumberPeople(Integer peopleNumber) {
        return Room
                .builder()
                .peopleNumber(peopleNumber)
                .build();
    }

    public Room createRoomByPriceForNight(float price) {
        return Room
                .builder()
                .priceForNight(price)
                .build();
    }
}
