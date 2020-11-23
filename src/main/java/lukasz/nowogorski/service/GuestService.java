package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.Guest;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@Log4j2
@AllArgsConstructor
public class GuestService {


    public Comparator<Guest> compareGuestByNameAndSurname()
    {
        return Comparator.comparing(Guest::getChild,Boolean::compareTo)
                .thenComparing(Guest::getName)
                .thenComparing(Guest::getSurname);
    }

    public Comparator<Guest> compareGuestByBirthAndTelephone()
    {
        return Comparator.comparing(Guest::getChild,Boolean::compareTo)
                .thenComparing(Guest::getDateOfBirth)
                .thenComparing(Guest::getTelephone);
    }

}
