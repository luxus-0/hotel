package lukasz.nowogorski.service.validation;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ValidEarlyCheckInTime {

    public void validate(LocalTime earlyCheckIn)
    {
        if(earlyCheckIn != LocalTime.now())
        {
            System.out.println("Early check in time: " +earlyCheckIn);
        }
        else
        {
            System.out.println("Wrong early check in time: ");
        }
    }
}
