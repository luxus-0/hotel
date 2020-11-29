package lukasz.nowogorski.service.validation;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ValidCheckOutTime {

    public void validate(LocalTime checkOut)
    {
        if(checkOut != LocalTime.now())
        {
            System.out.println("Wrong check out time");
        }
        else
        {
            System.out.println("Check out time: "+checkOut);
        }
    }
}
