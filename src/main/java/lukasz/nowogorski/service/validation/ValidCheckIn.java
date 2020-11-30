package lukasz.nowogorski.service.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Log4j2
public class ValidCheckIn {

    public void validate(LocalDateTime checkIn) {
        for (int i = 0; i < 30; i++) {
            LocalDateTime beforeCheckInDays = LocalDateTime.now().minusDays(i);
            if (checkIn == beforeCheckInDays) {
                log.error("Check in date is before today!!!");
            }
        }
    }
}