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
@RequestMapping("/api/customers")
class CustomerController {


    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerRepository customerRepository;


    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping
    ResponseEntity<List<Customer>> read() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> read(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Customer>> read(@PathVariable Pageable page) {
        return ResponseEntity.ok(customerRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Customer>> read(@PathVariable Sort sort) {
        return ResponseEntity.ok(customerRepository.findAll(sort));
    }


    @PostMapping
    ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer result = customerRepository.save(customer);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    void delete() {

        customerRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}