package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchHotelService {


    public void searchHotel(String country,String city) {
        if(country.equals("Spain") && city.equals("Miracle"))
        {
            List<Address> addresses = new ArrayList<>();
            addresses.stream().filter(hotel -> hotel.getCity().equals("") &&
                                    hotel.getCountry().equals("")).forEach(System.out::println);
        }

    }
}
