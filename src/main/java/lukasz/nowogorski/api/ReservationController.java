package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Reservation;
import lukasz.nowogorski.domain.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    @ApiOperation(value = "find reservations")
    public List<Reservation> getReservation()
    {
        return reservationService.findReservation();
    }


    @GetMapping("/reservations/{id}")
    @ApiOperation(value = "find by id")
    public Reservation getReservationById(@PathVariable Long id)
    {
        return reservationService.findReservationById(id);
    }

    @GetMapping("/reservations/{adultNumber}")
    @ApiOperation(value = "find by adultNumber")
    public List<Reservation> getReservationByAdultNumber(@PathVariable Integer adultNumber)
    {
        return reservationService.findReservationByAdultNumber(adultNumber);
    }

    @GetMapping("/reservations/{childrenNumber}")
    @ApiOperation(value = "find by childrenNumber")
    public List<Reservation> getReservationByChildrenNumber(@PathVariable Integer childrenNumber)
    {
        return reservationService.findReservationByChildrenNumber(childrenNumber);
    }


    @GetMapping("/reservations/{extraBedNumber}")
    @ApiOperation(value = "find by extraBedNumber")
    public List<Reservation> getReservationByExtraBedNumber(@PathVariable Integer extraBedNumber)
    {
        return reservationService.findReservationByExtraBedNumber(extraBedNumber);
    }


    @GetMapping("/reservations/{isPayment}")
    @ApiOperation(value = "find by payment")
    public List<Reservation> getReservationByPayment(@PathVariable String payment)
    {
        return reservationService.findReservationByPayment(payment);
    }


    @PostMapping("/reservations")
    @ApiOperation(value = "save reservation")
    public Reservation addReservation(@RequestBody Reservation reservation)
    {
        return reservationService.saveReservation(reservation);
    }

    @PutMapping("/reservations/{id]")
    @ApiOperation(value = "update reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable Long id)
    {
        return reservationService.updateReservation(reservation,id);
    }

    @DeleteMapping("/reservations")
    @ApiOperation(value = "delete reservation")
    public void deleteReservation()
    {
        reservationService.deleteReservation();
    }

    @DeleteMapping("/reservations/{id}")
    @ApiOperation(value = "delete id")
    public void deleteReservation(@PathVariable Long id)
    {
        reservationService.deleteReservationById(id);
    }
}
