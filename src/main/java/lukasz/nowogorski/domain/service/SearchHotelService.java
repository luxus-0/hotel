package lukasz.nowogorski.domain.service;

import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.domain.model.Address;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Log4j2
public class SearchHotelService {

    public void searchHotel() {

        ShowHotelAddress showHotelAddress = new ShowHotelAddress();
        Set<Address> hotelAddresses = new HashSet<>();
        hotelAddresses.add(showHotelAddress.getHotelAddress1());
        hotelAddresses.add(showHotelAddress.getHotelAddress2());
        hotelAddresses.add(showHotelAddress.getHotelAddress3());

        for(Address addr : hotelAddresses)
        {
            log.info(addr::getCountry);
            log.info(addr::getCity);
            log.info(addr::getPostal_code);
            log.info(addr::getStreet);
            log.info(addr::getNumber);
        }


    }


}
