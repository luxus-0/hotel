package hotel_app.hotel.controller;

import hotel_app.hotel.entity.BookingDate;
import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookingDates")
public class BookingDateController {


        private static final Logger log = LoggerFactory.getLogger(hotel_app.hotel.controller.AddressController.class);
        private final BookingDateRepository bookingDateRepository;

    public BookingDateController(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }


    @GetMapping
    ResponseEntity<List<BookingDate>> read()
        {
            return ResponseEntity.ok(bookingDateRepository.findAll());
        }

        @GetMapping("/{id}")
        ResponseEntity<BookingDate> read(@PathVariable Long id)
        {

            return bookingDateRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }


        @GetMapping("/{page}")
        ResponseEntity<Page<BookingDate>> read(@PathVariable Pageable page)
        {
            return ResponseEntity.ok(bookingDateRepository.findAll(page));
        }

        @GetMapping("/{sort}")
        ResponseEntity<List<BookingDate>> read(@PathVariable Sort sort)
        {
            return ResponseEntity.ok(bookingDateRepository.findAll(sort));
        }



        @PostMapping
        ResponseEntity<BookingDate> create(@RequestBody BookingDate bookingDate)
        {
            BookingDate result = bookingDateRepository.save(bookingDate);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{id}")
        ResponseEntity<BookingDate> update(@RequestBody BookingDate bookingDate, @PathVariable Long id)
        {
            if (!bookingDateRepository.existsById(id))
            {
                ResponseEntity.notFound().build();
            }
           bookingDate.setId(id);
            bookingDateRepository.save(bookingDate);
            return ResponseEntity.ok(bookingDate);
        }

        @DeleteMapping
        void delete()
        {
            bookingDateRepository.deleteAll();

        }

        @DeleteMapping("/{id}")
        void deleteById(@PathVariable Long id)
        {
            bookingDateRepository.deleteById(id);
        }

    }
