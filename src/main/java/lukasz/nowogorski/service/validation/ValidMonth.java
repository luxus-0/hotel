package lukasz.nowogorski.service.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Log4j2
public class ValidMonth {

        public void validate(LocalDateTime checkIn, LocalDateTime checkOut)
        {
            if(checkOut.getMonth().getValue() < checkIn.getMonth().getValue())
            {
                log.error("Month check out less than month check in!!");
            }
            else
            {
                log.info("Check in: " +checkIn);
                log.info("Check out: " +checkOut);
            }
        }
}
