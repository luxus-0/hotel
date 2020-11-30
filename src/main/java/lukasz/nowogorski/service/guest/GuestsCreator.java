package lukasz.nowogorski.service.guest;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.Gender;
import lukasz.nowogorski.model.Guest;
import org.springframework.stereotype.Service;
import java.io.File;
import java.time.LocalDate;

@Service
@Log4j2
@AllArgsConstructor
public class GuestsCreator {

    public Guest createGuest()
    {
            return Guest.builder()
                    .id(1L)
                    .name("lukos")
                    .secondName("milos")
                    .surname("wladimir")
                    .gender(Gender.MALE)
                    .child(false)
                    .pesel(12334242433L)
                    .dateOfBirth(LocalDate.of(2000,12,12))
                    .nationality("Rus")
                    .telephone("+12347755643")
                    .email("asdsd@ood.sa")
                    .password(String.valueOf(new File("c:/guestPassword/","pswd.txt").getFreeSpace()))
                    .build();
            }
    }
