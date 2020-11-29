package lukasz.nowogorski.service.validation;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ValidLateCheckOutTime {

    public void validate(LocalTime lateCheckOut)
    {
        if(lateCheckOut.isAfter(LocalTime.now()))
        {
            System.out.println("Late check in time: " +lateCheckOut);
        }
        else if(lateCheckOut.isBefore(LocalTime.now()))
        {
            System.out.println("Wrong late check in time: ");
        }
    }
}
