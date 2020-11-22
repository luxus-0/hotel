package lukasz.nowogorski.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.domain.model.Room;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPriceService {

    private final AvailableReservationService service;

    public float showPriceForOneNight()
    {
        Room room = new Room();
        float price = room.getPeopleNumber() * room.getPriceForNight();
        if (room.getPriceForNight() != 0 && room.getPeopleNumber() != 0) {
            log.info("price for night: " +price);
        }
        else {
            log.info("Price for night is empty");
        }

        return price;
    }

    public float showPriceForAllNight(Integer numberDays)
    {
        return showPriceForOneNight() * service.numberDaysReservation(numberDays);
    }
}
