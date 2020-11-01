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

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reservations")
class ReservationController
{

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

        @GetMapping("/{createdDate}")
    ResponseEntity<List<LocalDate>> readByCreatedDate(@PathVariable LocalDate createdDate)
    {
        return ResponseEntity.ok(readReservationService.findByCreatedDate(createdDate));
    }

    @GetMapping("/{numberChildren}")
    ResponseEntity<List<Integer>> readByNumberChildren(@PathVariable Integer numberChildren)
    {
        return ResponseEntity.ok(readReservationService.findByNumberChildren(numberChildren));
    }

    @GetMapping("/{numberAdult}")
    ResponseEntity<List<Integer>> readByNumberAdult(@PathVariable Integer numberAdult)
    {
        return ResponseEntity.ok(readReservationService.findByNumberAdult(numberAdult));
    }

    @GetMapping("/{numberBed}")
    ResponseEntity<List<Integer>> readByNumberBed(@PathVariable Integer numberBed)
    {
        return ResponseEntity.ok(readReservationService.findByNumberBed(numberBed));
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

    @PutMapping("/{createdDate}")
    void updateByCreatedDate(@PathVariable LocalDate createdDate)
    {
        updateReservationService.updateByCreatedDate(createdDate);
    }

    @PutMapping("/{numberChildren}")
    void updateByNumberChildren(@PathVariable Integer numberChildren)
    {
        updateReservationService.updateByNumberChildren(numberChildren);
    }

    @PutMapping("/{numberAdult}")
    void updateByNumberAdult(@PathVariable Integer numberAdult)
    {
        updateReservationService.updateByNumberAdult(numberAdult);
    }

    @PutMapping("/{numberBed}")
    void updateByNumberBed(Integer numberBed)
    {
        updateReservationService.updateByNumberBed(numberBed);
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

    @DeleteMapping("/{createdDate}")
    public void deleteByCreatedDate(@PathVariable LocalDate createdDate){

        deleteReservationService.deleteByCreatedDate(createdDate);
    }

    @DeleteMapping("/{numberChildren}")
    public void deleteByNumberChildren(@PathVariable Integer numberChildren)
    {
        deleteReservationService.deleteByNumberChildren(numberChildren);
    }

    @DeleteMapping("/{numberAdult}")
    public void deleteByNumberAdult(@PathVariable Integer numberAdult)
    {
        deleteReservationService.deleteByNumberAdult(numberAdult);
    }

    @DeleteMapping("/{numberBed}")
    public void deleteByNumberBed(@PathVariable Integer numberBed)
    {
        deleteReservationService.deleteByNumberBed(numberBed);
    }
}
