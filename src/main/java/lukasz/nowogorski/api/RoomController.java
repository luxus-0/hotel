package lukasz.nowogorski.api;

import lukasz.nowogorski.domain.model.Room;
import lukasz.nowogorski.infrastructure.postgres.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    
    private RoomRepository repository;


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
