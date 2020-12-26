package lukasz.nowogorski.hotel.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ValidRoomPrice {

  public void valid(Integer peopleNumber,double priceForNight)
    {
        if(peopleNumber < 0)
        {
            log.error("People number is less than 0!!");
        }
        else if(peopleNumber == 0)
        {
            log.error("People number is 0!!");
        }
        else if(priceForNight < 0)
        {
            log.error("Price for night is less than 0!!");
        }
        else if(priceForNight == 0)
        {
            log.error("Price for night is 0!!");
        }
    }
}
