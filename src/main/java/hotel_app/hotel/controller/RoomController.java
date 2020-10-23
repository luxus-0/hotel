package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    ResponseEntity<List<Room>> read()
    {
        return ResponseEntity.ok(roomRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Room> read(@PathVariable Long id)
    {

        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Room>> read(@PathVariable Pageable page)
    {
        return ResponseEntity.ok(roomRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Room>> read(@PathVariable Sort sort)
    {
        return ResponseEntity.ok(roomRepository.findAll(sort));
    }



    @PostMapping
    ResponseEntity<Room> create(@RequestBody Room room)
    {
        Room result = roomRepository.save(room);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Room> update(@RequestBody Room room, @PathVariable Long id)
    {
        if (!roomRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        room.setId(id);
        roomRepository.save(room);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping
    void delete()
    {
        roomRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
    {
        roomRepository.deleteById(id);
    }
}

