package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.model.Guest;

import java.time.LocalDateTime;
import java.util.List;

public interface GuestService {

    List<Guest> findGuest();
    Guest findGuestById(Long id);
    List<Guest> findGuestByName(String name);
    List<Guest> findGuestBySecondName(String secondName);
    List<Guest> findGuestBySurname(String surname);
    List<Guest> findGuestByGender(Gender gender);
    List<Guest> findGuestByPesel(Long pesel);
    List<Guest> findGuestByNationality(String nationality);
    List<Guest> findGuestByDateOfBirth(LocalDateTime dateOfBirth);
    List<Guest> findGuestByTelephone(String telephone);
    List<Guest> findGuestByEmail(String email);
    Guest saveGuest(Guest guest);
    Guest updateGuest(Guest guest, Long id);
    void deleteGuest();
    void deleteGuestById(Long id);
}
