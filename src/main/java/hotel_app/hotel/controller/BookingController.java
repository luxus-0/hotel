package hotel_app.hotel.controller;

import hotel_app.hotel.repository.BookingRepository;
import hotel_app.hotel.entity.Booking;
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
class BookingController
{

private static final Logger log = LoggerFactory.getLogger(BookingController.class);
private final BookingRepository repository;

    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Booking>> read()
        {
            return ResponseEntity.ok(repository.findAll());
        }

@GetMapping("/{id}")
    ResponseEntity<Booking> read(Long id)
        {
            return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
        }

@GetMapping("/{page}")
    ResponseEntity<Page<Booking>> read(@RequestParam Pageable page)
        {
            return ResponseEntity.ok(repository.findAll(page));
        }

@GetMapping("/{sort}")
    ResponseEntity<List<Booking>> read(@RequestParam Sort sort)
        {
            return ResponseEntity.ok(repository.findAll(sort));
        }



@PostMapping
    ResponseEntity<Booking> create(@RequestBody Booking booking)
        {
            Booking result = repository.save(booking);
            return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
        }

@PutMapping("/{id}")
    ResponseEntity<Booking> update(@RequestBody Booking booking,@PathVariable Long id)
        {
        if (!repository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }

            booking.setId(id);
            repository.save(booking);
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
