package hotel_app.hotel.controller;

import hotel_app.hotel.repository.CustomerRepository;
import hotel_app.hotel.entity.Customer;
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
class CustomerController {


    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerRepository customerRepository;


    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    ResponseEntity<List<Customer>> read() {
        log.info("Read Customer");
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/customers/{id}")
    ResponseEntity<Customer> read(Long id) {
        log.info("Customer id");
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/customers/{page}")
    ResponseEntity<Page<Customer>> read(@RequestParam Pageable page) {
        log.info("Customer Page");
        return ResponseEntity.ok(customerRepository.findAll(page));
    }

    @GetMapping("/customers/{sort}")
    ResponseEntity<List<Customer>> read(@RequestParam Sort sort) {
        log.info("Customer Sort");
        return ResponseEntity.ok(customerRepository.findAll(sort));
    }


    @PostMapping("/customers")
    ResponseEntity<Customer> create(@RequestBody Customer customer) {
        log.info("Customer Save");
        Customer result = customerRepository.save(customer);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("/customers/{id}")
    ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable Long id) {
        log.info("Customer Update");
        if (!customerRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/customers")
    void delete() {

        log.info("Customer Delete");
        customerRepository.deleteAll();


    }

    @DeleteMapping("/customers/{id}")
    void deleteById(@PathVariable Long id) {
        log.info("Customer Delete by Id: " +id);
        customerRepository.deleteById(id);
    }
}