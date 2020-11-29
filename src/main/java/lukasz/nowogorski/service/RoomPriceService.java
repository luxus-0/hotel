package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class RoomPriceService {

    public List<Integer> getPeopleNumber()
    {
        List<Integer> peopleNumber = List.of(1,2,3,4,5,6,7,8,9,10);
        peopleNumber
                .stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        return peopleNumber;
    }

    public List<Double> getPriceForNight() {
        List<Double> price = List.of(12.30,30.12,40.43,78.15,104.37,156.12,170.90,193.12,198.22,199.23,200.00);
        return price.stream()
                .filter(p -> p > 0)
                .limit(200)
                .collect(Collectors.toList());

    }

    public void getPriceForAllNight()
    {
        for (int i = 0; i < getPeopleNumber().size(); i++)
        {
            for(int j = 0; j < getPriceForNight().size(); j++)
            {
                double allPrice = getPeopleNumber().indexOf(i) * getPriceForNight().indexOf(j);
                System.out.println("People number: " + getPeopleNumber().indexOf(i)
                               + "\nPrice for night " + getPriceForNight().indexOf(j));
                List<Double> price = new ArrayList<>();
                price.add(allPrice);
                price
                        .stream()
                        .filter(priceList -> priceList > 0)
                        .forEach(priceNight -> System.out.println("All price for night: " +priceNight));
                }
            }
    }

}
