package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Room;
import org.springframework.stereotype.Service;

import java.util.Random;

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
}
