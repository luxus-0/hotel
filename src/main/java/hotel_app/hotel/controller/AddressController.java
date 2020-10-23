package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Address;
import hotel_app.hotel.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
class AddressController {


    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private final AddressRepository addressRepository;

    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @GetMapping
    ResponseEntity<List<Address>> read()
    {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Address> read(@PathVariable Long id)
    {

        return addressRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Address>> read(@PathVariable Pageable page)
    {
        return ResponseEntity.ok(addressRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Address>> read(@PathVariable Sort sort)
    {
        return ResponseEntity.ok(addressRepository.findAll(sort));
    }



    @PostMapping
    ResponseEntity<Address> create(@RequestBody Address address)
    {
        Address result = addressRepository.save(address);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Address> update(@RequestBody Address address, @PathVariable Long id)
    {
        if (!addressRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        address.setId(id);
        addressRepository.save(address);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping
    void delete()
    {
        addressRepository.deleteAll();

    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
    {
        addressRepository.deleteById(id);
    }

}
