package lukasz.nowogorski.service.validation;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ValidCheckInTime {

    public void validate(LocalTime checkIn)
    {
        if(checkIn != LocalTime.now())
        {
            System.out.println("Wrong check in time");
        }
        else
        {
            System.out.println("Check in time: "+checkIn);
        }
    }
}
