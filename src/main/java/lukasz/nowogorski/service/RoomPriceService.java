package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.service.reservation.ReservationTime;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPriceService {

    private final ReservationTime service;

    public List<Float> getPriceForNight(Integer peopleNumber, Float priceForNight) {
        List<Integer> peoples = new ArrayList<>(List.of(peopleNumber));
        List<Float> price = new ArrayList<>(List.of(priceForNight));

        peoples.add(peopleNumber);
        price.add(priceForNight);

        peoples.stream()
                .filter(exe -> exe > 0)
                .forEach(b -> System.out.println("Number people: " + b));

        price.stream()
                .filter(e -> e > 0)
                .forEach(b -> System.out.println("Price for night: " + b));

        return price;
    }

    /*
    public float getPriceForAllNight(Integer peopleNumber,Float priceForNight,Integer numberDays)
    {
        return getPriceForNight(peopleNumber,priceForNight) * service.numberDaysReservation(numberDays);
    }
*/
}
