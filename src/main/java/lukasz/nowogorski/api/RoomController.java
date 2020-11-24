package lukasz.nowogorski.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.model.Room;
import lukasz.nowogorski.repository.RoomRepository;
import lukasz.nowogorski.service.AvailableReservationService;
import lukasz.nowogorski.service.RoomPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class RoomController {
    
    private final RoomRepository repository;
    private final RoomPriceService price;
    private final AvailableReservationService available;

    @GetMapping("/rooms")
    public List<Room> getRoom()
    {
        return repository.findAll();
    }


    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/rooms/beds/{beds}")
    public Room getRoomByBeds(Integer beds)
    {
        return available.findRoomByBeds(beds);
    }

    @GetMapping("/rooms/peopleNumber/{peopleNumber}")
    public Room getRoomByPeopleNumber(Integer peopleNumber)
    {
        return available.findRoomByNumberPeople(peopleNumber);
    }


    @GetMapping("/rooms/{peopleNumber}/{priceForNight}")
    public float getRoomByPriceForNight(@PathVariable Integer peopleNumber, @PathVariable Float priceForNight)
    {
       return price.showPriceForOneNight(peopleNumber,priceForNight);
    }

    @GetMapping("/rooms/{peopleNumber}/{priceForNight}/{numberDays}")
    public float getRoomByPriceForAllNight(@PathVariable Integer peopleNumber, @PathVariable Float priceForNight,@PathVariable Integer numberDays)
    {
        return price.showPriceForAllNight(peopleNumber,priceForNight,numberDays);
    }


    @PostMapping("/rooms")
    public Room saveRoom(@RequestBody Room room)
    {
        return repository.save(room);
    }

    @PutMapping("/rooms/{id]")
    public Room updateRoom(@RequestBody Room room,@PathVariable Long id)
    {
        return repository.updateRoom(room,id);
    }

    @DeleteMapping("/rooms")
    public void deleteRoom()
    {
        repository.deleteAll();
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
