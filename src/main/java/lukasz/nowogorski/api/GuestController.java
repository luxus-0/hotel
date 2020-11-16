package lukasz.nowogorski.api;

import lukasz.nowogorski.domain.model.Guest;
import lukasz.nowogorski.infrastructure.postgres.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {

    private final GuestRepository repository;

    public GuestController(GuestRepository repository) {
        this.repository = repository;
    }

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
