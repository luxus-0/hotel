package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Guest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GuestCreatorService {

    public Guest create(Guest guest)
    {
        return Guest.builder()
                .id(guest.getId())
                .name(guest.getName())
                .secondName(guest.getSecondName())
                .surname(guest.getSurname())
                .pesel(guest.getPesel())
                .telephone(guest.getTelephone())
                .gender(guest.getGender())
                .email(guest.getEmail())
                .dateOfBirth(guest.getDateOfBirth())
                .nationality(guest.getNationality())
                .gender(guest.getGender())
                .dateOfBirth(guest.getDateOfBirth())
                .build();

    }
}
