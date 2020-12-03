package lukasz.nowogorski.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Log4j2
public class ValidDate {
    public void validate(LocalDateTime checkIn, LocalDateTime checkOut) {
        if (checkIn == null)
        {
            log.info("Check in is empty");
        }
        else if (checkOut == null)
        {
            log.info("Check out is empty");
        }
        else if (checkOut.getDayOfMonth() < checkIn.getDayOfMonth()) {
            log.error("Day check out less than day check in!!");
        } else if (checkOut.getMonth().getValue() < checkIn.getMonth().getValue()) {
            log.error("Month check out less than month check in!!");
        } else if (checkOut.getYear() < checkIn.getYear()) {
            log.error("Year check out less than Year check in!!");
        } else {
            log.info("Check in: " + checkIn);
            log.info("Check out: " + checkOut);
        }
    }
}
