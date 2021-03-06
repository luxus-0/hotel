package lukasz.nowogorski.hotel.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.hotel.model.Guest;
import lukasz.nowogorski.hotel.repository.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GuestController {

    private final GuestRepository repository;

    @GetMapping("/guests")
    public List<Guest> getGuest()
    {
        return repository.findAll();
    }


    @GetMapping("/guests/{id}")
    public Optional<Guest> getGuest(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/guests/{name}/{surname}")
    public Guest getNameAndSurname(@PathVariable String name,@PathVariable String surname)
    {
        return repository.findGuestByNameAndSurname(name,surname);
    }

    @PostMapping("/guests")
    public Guest saveGuest(@RequestBody Guest guest)
    {
        return repository.save(guest);
    }

    @PutMapping("/guests/{id}")
    public Guest updateGuest(@RequestBody Guest guest,@PathVariable Long id)
    {
        return repository.updateGuest(guest,id);
    }

    @DeleteMapping("/guests")
    public void deleteGuest()
    {
        repository.deleteAll();
    }

    @DeleteMapping("/guests/{id}")
    public void deleteGuest(@PathVariable Long id)
    {
        repository.deleteById(id);
    }

}
