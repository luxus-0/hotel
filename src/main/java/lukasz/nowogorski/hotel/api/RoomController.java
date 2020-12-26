package lukasz.nowogorski.hotel.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.hotel.model.Room;
import lukasz.nowogorski.hotel.repository.RoomRepository;
import lukasz.nowogorski.hotel.service.RoomPrice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class RoomController {
    
    private final RoomRepository repository;
    private final RoomPrice price;

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
