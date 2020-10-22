package hotel_app.hotel.api;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.mapper.BookingMapper;
import hotel_app.hotel.repository.BookingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingApi {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;

    public BookingApi(BookingRepository bookingRepository, BookingMapper mapper) {
        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
    }

    @GetMapping
    ResponseEntity<List<BookingDTO>> read()
    {
        return ResponseEntity.ok(mapper.toBookingDTOlist(bookingRepository.findAll()));
    }

    @GetMapping("/bookings/{id}")
    ResponseEntity<Booking> read(Long id)
    {
        log.info("Booking id");
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bookings/{page}")
    ResponseEntity<Page<Booking>> read(@RequestParam Pageable page)
    {
        log.info("Bookings Page");
        return ResponseEntity.ok(repository.findAll(page));
    }

    @GetMapping("/bookings/{sort}")
    ResponseEntity<List<Booking>> read(@RequestParam Sort sort)
    {
        log.info("Bookings Sort");
        return ResponseEntity.ok(repository.findAll(sort));
    }



    @PostMapping("/bookings")
    ResponseEntity<Booking> create(@RequestBody Booking booking)
    {
        log.info("Bookings Save");
        Booking result = repository.save(booking);
        return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
    }

    @PutMapping("/bookings/{id}")
    ResponseEntity<Booking> update(@RequestBody Booking booking,@PathVariable Long id)
    {
        log.info("Bookings Update");
        if (!repository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }

        booking.setId(id);
        repository.save(booking);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bookings")
    void delete()
    {
        log.info("Bookings Delete");
        repository.deleteAll();
    }

    @DeleteMapping("/bookings/{id}")
    void deleteById(@PathVariable Long id)
    {
        log.info("Bookings Delete ID: " +id);
        repository.deleteById(id);
    }
}
