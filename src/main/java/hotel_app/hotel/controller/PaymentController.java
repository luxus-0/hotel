package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Payment;
import hotel_app.hotel.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentRepository paymentRepository;


    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @GetMapping
    ResponseEntity<List<Payment>> read()
    {
        return ResponseEntity.ok(paymentRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Payment> read(@PathVariable Long id)
    {

        return paymentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Payment>> read(@PathVariable Pageable page)
    {
        return ResponseEntity.ok(paymentRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Payment>> read(@PathVariable Sort sort)
    {
        return ResponseEntity.ok(paymentRepository.findAll(sort));
    }



    @PostMapping
    ResponseEntity<Payment> create(@RequestBody Payment payment)
    {
        Payment result = paymentRepository.save(payment);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Payment> update(@RequestBody Payment payment, @PathVariable Long id)
    {
        if (!paymentRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        payment.setId(id);
        paymentRepository.save(payment);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping
    void delete()
    {
        paymentRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
    {
        paymentRepository.deleteById(id);
    }
}
