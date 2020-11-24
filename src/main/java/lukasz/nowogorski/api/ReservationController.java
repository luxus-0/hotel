package lukasz.nowogorski.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.model.Reservation;
import lukasz.nowogorski.repository.ReservationRepository;
import lukasz.nowogorski.service.AvailableReservationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationRepository repository;
    private final AvailableReservationService available;

    @GetMapping("/reservations")
    public List<Reservation> getReservation()
    {
        return repository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/reservations/available/{beds}/{numberPeople}")
    public boolean getReservationByAvailable(Integer beds,Integer numberPeople)
    {
           return available.availableReservation(beds,numberPeople);
    }

    @GetMapping("/reservations/days/{number}")
    public Long getReservationByNumberDays(Integer number)
    {
        return available.numberDaysReservation(number);
    }

    @PostMapping("/reservations")
    public Reservation saveReservation(@RequestBody Reservation reservation)
    {
        return repository.save(reservation);
    }

    @PutMapping("/reservations/{id]")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable Long id)
    {
        return repository.updateReservation(reservation,id);
    }

    @DeleteMapping("/reservations")
    public void deleteReservation()
    {
        repository.deleteAll();
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
