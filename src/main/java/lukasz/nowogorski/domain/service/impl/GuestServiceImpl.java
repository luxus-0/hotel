package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.model.Guest;
import lukasz.nowogorski.domain.service.GuestService;
import lukasz.nowogorski.infrastructure.postgres.GuestRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
final class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    public GuestServiceImpl(GuestRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Guest> findGuest() {
        return repository.findAll();
    }

    @Override
    public Guest findGuestById(Long id) {
        Optional<Guest> guestOptional = repository.findById(id);
        return guestOptional.orElseThrow(() -> new EntityNotFoundException("No guest with such id: " +id));
    }

    @Override
    public List<Guest> findGuestByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Guest> findGuestBySecondName(String secondName) {
        return repository.findBySecondName(secondName);
    }

    @Override
    public List<Guest> findGuestBySurname(String surname) {
        return repository.findBySurname(surname);
    }

    @Override
    public List<Guest> findGuestByGender(Gender gender) {
        return repository.findByGender(gender);
    }

    @Override
    public List<Guest> findGuestByPesel(Long pesel) {
        return repository.findByPesel(pesel);
    }

    @Override
    public List<Guest> findGuestByNationality(String nationality) {
        return repository.findByNationality(nationality);
    }

    @Override
    public List<Guest> findGuestByDateOfBirth(LocalDateTime dateOfBirth) {
        return repository.findByDateOfBirth(dateOfBirth);
    }

    @Override
    public List<Guest> findGuestByTelephone(String telephone) {
        return repository.findByTelephone(telephone);
    }

    @Override
    public List<Guest> findGuestByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public Guest updateGuest(Guest guest, Long id) {
        return repository.update(guest,id);
    }

    @Override
    public void deleteGuest() {
        repository.deleteAll();
    }

    @Override
    public void deleteGuestById(Long id) {
        repository.deleteById(id);
    }
}
