package lukasz.nowogorski.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.model.Hotel;
import lukasz.nowogorski.service.CheckInReservationService;
import lukasz.nowogorski.service.CostReservationService;
import lukasz.nowogorski.service.SearchHotelService;
import lukasz.nowogorski.repository.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class HotelController {

    private final HotelRepository repository;
    private final CostReservationService cost;


    @GetMapping("/hotels")
    public List<Hotel> getHotel()
    {
        return repository.findAll();
    }


    @GetMapping("/hotels/{id}")
    public Optional<Hotel> getHotel(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/hotels/address/{address}")
    public Hotel getAddress(@PathVariable String address)
    {
        return repository.findHotelByAddress(address);
    }

    @GetMapping("/hotels/name/{name}")
    public Hotel getName(@PathVariable String name)
    {
        return repository.findHotelByName(name);
    }

    @GetMapping("/hotels/search")
    public void searchHotel()
    {
        SearchHotelService hotel = new SearchHotelService();
        hotel.searchHotel();
    }

    @GetMapping("/hotels/allowCheckIn")
    public List<LocalTime> allowCheckInTime()
    {
        CheckInReservationService checkIn = new CheckInReservationService();
        return checkIn.allowCheckInTime();
    }

    @GetMapping("/hotels/allowCheckOut")
    public List<LocalTime> allowCheckOutTime()
    {
        CheckInReservationService checkOut = new CheckInReservationService();
        return checkOut.allowCheckOutTime();
    }

    @GetMapping("/hotels/cost/lateCheckOut")
    public double costLateCheckOutDate()
    {
        return cost.costLateCheckOut();
    }

    @PostMapping("/hotels")
    public Hotel saveHotel(@RequestBody Hotel hotel)
    {
        return repository.save(hotel);
    }

    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@RequestBody Hotel hotel, @PathVariable Long id)
    {
        return repository.updateHotel(hotel,id);
    }

    @DeleteMapping("/hotels")
    public void deleteHotel()
    {
        repository.deleteAll();
    }

    @DeleteMapping("/hotels/{id}")
    public void deleteHotel(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
