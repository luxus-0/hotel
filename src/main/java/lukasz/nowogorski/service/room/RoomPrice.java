package lukasz.nowogorski.service.room;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPrice {

    /*public double getPrice()
    {
        for (int i = 0; i < getPeopleNumber().size(); i++)
        {
            for (int j = 0; j < getPriceForNight().size(); j++)
            {
                double allPrice = getPeopleNumber().indexOf(i) * getPriceForNight().indexOf(j);
                System.out.println("People number: " + getPeopleNumber().indexOf(i)
                               + "\nPrice for night " + getPriceForNight().indexOf(j));
                List<Double> price = new ArrayList<>();
                price.add(allPrice);
                price
                        .stream()
                        .filter(priceList -> priceList > 0)
                        .forEach(priceNight -> System.out.println("All price for night: " + priceNight));
            }
        }
    }

        public double getPriceByHour()
        {

        }

        public double getPriceByTypeRoom()
        {

        }

        public double getPriceByNumberBed()
        {

        }

        public double getPriceByNumberRoom()
        {

        }*/
}
