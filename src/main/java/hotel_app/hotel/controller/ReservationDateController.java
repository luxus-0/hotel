package hotel_app.hotel.controller;

import hotel_app.hotel.entity.ReservationDate;
import hotel_app.hotel.repository.ReservationDateRepository;
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
public class ReservationDateController {


        private static final Logger log = LoggerFactory.getLogger(hotel_app.hotel.controller.AddressController.class);
        private final ReservationDateRepository reservationDateRepository;

    public ReservationDateController(ReservationDateRepository reservationDateRepository) {
        this.reservationDateRepository = reservationDateRepository;
    }


    @GetMapping
    ResponseEntity<List<ReservationDate>> read()
        {
            return ResponseEntity.ok(reservationDateRepository.findAll());
        }

        @GetMapping("/{id}")
        ResponseEntity<ReservationDate> read(@PathVariable Long id)
        {

            return reservationDateRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }


        @GetMapping("/{page}")
        ResponseEntity<Page<ReservationDate>> read(@PathVariable Pageable page)
        {
            return ResponseEntity.ok(reservationDateRepository.findAll(page));
        }

        @GetMapping("/{sort}")
        ResponseEntity<List<ReservationDate>> read(@PathVariable Sort sort)
        {
            return ResponseEntity.ok(reservationDateRepository.findAll(sort));
        }



        @PostMapping
        ResponseEntity<ReservationDate> create(@RequestBody ReservationDate reservationDate)
        {
            ReservationDate result = reservationDateRepository.save(reservationDate);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{id}")
        ResponseEntity<ReservationDate> update(@RequestBody ReservationDate reservationDate, @PathVariable Long id)
        {
            if (!reservationDateRepository.existsById(id))
            {
                ResponseEntity.notFound().build();
            }
           reservationDate.setId(id);
            reservationDateRepository.save(reservationDate);
            return ResponseEntity.ok(reservationDate);
        }

        @DeleteMapping
        void delete()
        {
            reservationDateRepository.deleteAll();

        }

        @DeleteMapping("/{id}")
        void deleteById(@PathVariable Long id)
        {
            reservationDateRepository.deleteById(id);
        }

    }
