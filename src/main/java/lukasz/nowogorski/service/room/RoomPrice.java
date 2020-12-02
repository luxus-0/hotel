package lukasz.nowogorski.service.room;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.repository.RoomRepository;
import lukasz.nowogorski.service.validation.ValidRoomPrice;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPrice {

    private final ValidRoomPrice price;

    public BigDecimal getPrice(Integer peopleNumber,double priceForNight)
    {
        price.valid(peopleNumber,priceForNight);
        BigDecimal allPrice = BigDecimal.valueOf(peopleNumber * priceForNight);
        for (int i = 0; i <= peopleNumber; i++)
        {
            for (int j = 0; j <= priceForNight; j++)
            {
                System.out.println("People number: " + peopleNumber +"\nPrice for night " + priceForNight);
                List<BigDecimal> price = new ArrayList<>();
                price.add(allPrice);
                price
                        .stream()
                        .filter(priceList -> priceList.intValue() > 0)
                        .forEach(priceNight -> System.out.println("All price for night: " + priceNight));
            }
        }
        return allPrice;
    }
}
