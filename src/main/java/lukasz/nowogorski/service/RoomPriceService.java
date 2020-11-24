package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.Room;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPriceService {

    private final AvailableReservationService service;
    private final RoomCreatorService create;

    public float showPriceForOneNight(Integer peopleNumber,Float priceForNight)
    {
        Room number = create.createRoomByNumberPeople(peopleNumber);
        Room price = create.createRoomByPriceForNight(priceForNight);
        float all = number.getPeopleNumber() * price.getPriceForNight();
        if (price.getPriceForNight() != 0 && number.getPeopleNumber() != 0) {
            log.info("Number people: "+number);
            log.info("Price for night: " +price);
            log.info("All price: " +price);
        }
        else {
            log.info("Price for night is empty");
        }

        return all;
    }

    public float showPriceForAllNight(Integer peopleNumber,Float priceForNight,Integer numberDays)
    {
        return showPriceForOneNight(peopleNumber,priceForNight) * service.numberDaysReservation(numberDays);
    }
}
