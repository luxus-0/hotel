package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.service.CreateReservationService;
import hotel_app.hotel.service.DeleteReservationService;
import hotel_app.hotel.service.ReadReservationService;
import hotel_app.hotel.service.UpdateReservationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookings")
class ReservationController
{

private final Logger log = LoggerFactory.getLogger(ReservationController.class);
private final ReadReservationService readReservationService;
private final CreateReservationService createReservationService;
private final UpdateReservationService updateReservationService;
private final DeleteReservationService deleteReservationService;



    @GetMapping
    ResponseEntity<List<Reservation>> read()
        {
            return ResponseEntity.ok(readReservationService.find());
        }

@GetMapping("/{id}")
ResponseEntity<Reservation> read(@PathVariable Long id)
        {
            return ResponseEntity.ok(readReservationService.findById(id));
        }


@PostMapping
void create(@RequestBody Reservation reservation)
        {
            createReservationService.create(reservation);

        }

@PutMapping("/{id}")
void update(@RequestBody Reservation reservation, @PathVariable Long id)
        {
            updateReservationService.update(reservation,id);
        }

@DeleteMapping
void delete(@RequestBody Reservation reservation)
        {
            deleteReservationService.delete(reservation);
        }

@DeleteMapping("/{id}")
void deleteById(@PathVariable Long id)
        {
            deleteReservationService.deleteById(id);
        }
}
