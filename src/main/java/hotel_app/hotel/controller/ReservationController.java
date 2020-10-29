package hotel_app.hotel.controller;

import hotel_app.hotel.repository.ReservationRepository;
import hotel_app.hotel.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
class ReservationController
{

private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
private final ReservationRepository repository;

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Reservation>> read()
        {
            return ResponseEntity.ok(repository.findAll());
        }

@GetMapping("/{id}")
    ResponseEntity<Reservation> read(Long id)
        {
            return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
        }

@GetMapping("/{page}")
    ResponseEntity<Page<Reservation>> read(@PathVariable Pageable page)
        {
            return ResponseEntity.ok(repository.findAll(page));
        }

@GetMapping("/{sort}")
    ResponseEntity<List<Reservation>> read(@PathVariable Sort sort)
        {
            return ResponseEntity.ok(repository.findAll(sort));
        }



@PostMapping
    ResponseEntity<Reservation> create(@RequestBody Reservation reservation)
        {
            Reservation result = repository.save(reservation);
            return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
        }

@PutMapping("/{id}")
    ResponseEntity<Reservation> update(@RequestBody Reservation reservation, @PathVariable Long id)
        {
        if (!repository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }

            reservation.setId(id);
            repository.save(reservation);
            return ResponseEntity.noContent().build();
        }

@DeleteMapping
    void delete()
        {
            repository.deleteAll();
        }

@DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
        {
            repository.deleteById(id);
        }
}
