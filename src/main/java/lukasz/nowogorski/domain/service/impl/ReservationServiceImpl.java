package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.model.Reservation;
import lukasz.nowogorski.domain.service.ReservationService;
import lukasz.nowogorski.infrastructure.postgres.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Reservation> findReservation() {
        return repository.findAll();
    }

    @Override
    public Reservation findReservationById(Long id) {
        Optional<Reservation> reservationOptional = repository.findById(id);
        return reservationOptional.orElseThrow(() -> new EntityNotFoundException("No reservation with such id: " +id));
    }

    @Override
    public List<Reservation> findReservationByAdultNumber(Integer adultNumber) {
        return repository.findByAdultNumber(adultNumber);
    }

    @Override
    public List<Reservation> findReservationByChildrenNumber(Integer childrenNumber) {
        return repository.findByChildrenNumber(childrenNumber);
    }

    @Override
    public List<Reservation> findReservationByExtraBedNumber(Integer extraBedNumber) {
        return repository.findByExtraBedNumber(extraBedNumber);
    }

    @Override
    public List<Reservation> findReservationByPayment(String payment) {
        return repository.findByPayment(payment);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long id) {
        return repository.update(reservation,id);
    }

    @Override
    public void deleteReservation() {
        repository.deleteAll();
    }

    @Override
    public void deleteReservationById(Long id) {
        repository.deleteById(id);
    }
}
