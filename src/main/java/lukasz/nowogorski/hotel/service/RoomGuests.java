package lukasz.nowogorski.hotel.service;

import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.hotel.model.ReservationOnline;
import lukasz.nowogorski.hotel.model.Room;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RoomGuests {

    private ReservationOnline online;
    private ReservationOnlineCreator creator;
    private Room room;


    public void isRoomsFull()
    {
         if(getNumberGuests() > getNumberBeds())
        {
            log.info("Rooms are full!!");
        }
    }

    public void isRoomsEmpty()
    {
        if(getNumberGuests() < getNumberBeds())
        {
            log.info("Rooms are empty");
            creator.create();
        }
    }

    public int getNumberGuests()
    {
        return online.getGuests().size();
    }

    public Integer getNumberBeds()
    {
        return room.getBeds();
    }


}
