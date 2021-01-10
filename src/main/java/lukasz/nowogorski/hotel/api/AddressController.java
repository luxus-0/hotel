package lukasz.nowogorski.hotel.api;

import lukasz.nowogorski.hotel.model.AddressHotel;
import lukasz.nowogorski.hotel.repository.AddressRepository;
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
    public List<AddressHotel> getAddress()
    {
        return repository.findAll();
    }


    @GetMapping("/addresses/{id}")
    public Optional<AddressHotel> getAddress(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("/addresses/{city}/{street}")
    public AddressHotel getCityAndStreet(@PathVariable String city, @PathVariable String street)
    {
        return repository.findAddressByCityAndStreet(city,street);
    }


    @PostMapping("/addresses")
    public AddressHotel saveAddress(@RequestBody AddressHotel addressHotel)
    {
        return repository.save(addressHotel);
    }

    @PutMapping("/addresses/{id}")
    public AddressHotel updateAddress(@RequestBody AddressHotel addressHotel, @PathVariable Long id)
    {
        return repository.updateAddress(addressHotel,id);
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
