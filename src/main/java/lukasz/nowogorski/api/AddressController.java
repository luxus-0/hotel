package lukasz.nowogorski.api;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.infrastructure.postgres.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    private final AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/addresses")
    public List<Address> getAddress()
    {
        return repository.findAll();
    }


    @GetMapping("/addresses/{id}")
    public Optional<Address> getAddress(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/addresses/{city}/{street}")
    public Address getCityAndStreet(@PathVariable String city,@PathVariable String street)
    {
        return repository.findAddressByCityAndStreet(city,street);
    }


    @PostMapping("/addresses")
    public Address saveAddress(@RequestBody Address address)
    {
        return repository.save(address);
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@RequestBody Address address,@PathVariable Long id)
    {
        return repository.updateAddress(address,id);
    }

    @DeleteMapping("/addresses")
    public void deleteAddress()
    {
        repository.deleteAll();
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable Long id)
    {
        repository.deleteById(id);
    }


}
