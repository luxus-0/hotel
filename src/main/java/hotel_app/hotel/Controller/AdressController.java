package hotel_app.hotel.Controller;

import hotel_app.hotel.Repository.AddressRepository;
import hotel_app.hotel.Entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
class AdressController {


    private static final Logger log = LoggerFactory.getLogger(AdressController.class);
    private final AddressRepository addressRepository;

    AdressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @GetMapping("/adresses")
    ResponseEntity<List<Address>> read()
    {
        log.info("Read Adress");
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @GetMapping("/adresses/{id}")
    ResponseEntity<Address> read(Long id)
    {
        log.info("Adress id");
        return addressRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/adresses/{page}")
    ResponseEntity<Page<Address>> read(@RequestParam Pageable page)
    {
        log.info("Adress Page");
        return ResponseEntity.ok(addressRepository.findAll(page));
    }

    @GetMapping("/adresses/{sort}")
    ResponseEntity<List<Address>> read(@RequestParam Sort sort)
    {
        log.info("Adress Sort");
        return ResponseEntity.ok(addressRepository.findAll(sort));
    }



    @PostMapping("/adresses")
    ResponseEntity<Address> create(@RequestBody Address address)
    {
        log.info("Adress Save");
        Address result = addressRepository.save(address);
        return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
    }

    @PutMapping("/adresses/{id}")
    ResponseEntity<Address> update(@RequestBody Address address, @PathVariable Long id)
    {
        log.info("Adress Update");
        if (!addressRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        address.setId(id);
        addressRepository.save(address);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/adresses")
    void delete()
    {
        log.info("Adress Delete");
        addressRepository.deleteAll();

    }

    @DeleteMapping("/adresses/{id}")
    void deleteById(@PathVariable Long id)
    {
        log.info("Adress Delete ID: " +id);
        addressRepository.deleteById(id);

    }

}
