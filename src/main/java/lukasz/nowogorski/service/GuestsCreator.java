package lukasz.nowogorski.service;

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

    public Guest createGuest(Guest guest)
    {
            return Guest.builder()
                    .id(guest.getId())
                    .name(guest.getName())
                    .secondName(guest.getSecondName())
                    .surname(guest.getSurname())
                    .gender(guest.getGender())
                    .child(guest.getChild())
                    .pesel(guest.getPesel())
                    .dateOfBirth(guest.getDateOfBirth())
                    .nationality(guest.getNationality())
                    .telephone(guest.getTelephone())
                    .email(guest.getEmail())
                    .build();
            }


    public Guest createPassword(Guest guest)
    {
        return Guest.builder()
                .password(guest.getPassword())
                .build();
    }

}
