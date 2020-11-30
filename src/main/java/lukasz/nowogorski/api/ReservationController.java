package lukasz.nowogorski.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.model.ReservationOnline;
import lukasz.nowogorski.repository.ReservationOnlineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationOnlineRepository repository;

    @GetMapping("/reservations")
    public List<ReservationOnline> getReservation()
    {
        return repository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Optional<ReservationOnline> getReservationById(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @PostMapping("/reservations")
    public ReservationOnline saveReservation(@RequestBody ReservationOnline reservationOnline)
    {
        return repository.save(reservationOnline);
    }

    @PutMapping("/reservations/{id]")
    public ReservationOnline updateReservation(@RequestBody ReservationOnline reservationOnline, @PathVariable Long id)
    {
        return repository.updateReservation(reservationOnline,id);
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
