package lukasz.nowogorski.service.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.DateTimeException;
import java.time.LocalDate;

@Service
@Log4j2
public class ValidReservationDate {

    public void validate(LocalDate createdDate)
    {
        if(!createdDate.equals(LocalDate.now()))
        {
            throw new DateTimeException("Wrong created Date");
        }
        else
        {
            log.info("Created date Reservation");
        }
    }
}
