package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Extra;
import hotel_app.hotel.repository.ExtraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extras")
public class ExtraController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private final ExtraRepository extraRepository;

    public ExtraController(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @GetMapping
    ResponseEntity<List<Extra>> read()
    {
        return ResponseEntity.ok(extraRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Extra> read(@PathVariable Long id)
    {

        return extraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Extra>> read(@PathVariable Pageable page)
    {
        return ResponseEntity.ok(extraRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Extra>> read(@PathVariable Sort sort)
    {
        return ResponseEntity.ok(extraRepository.findAll(sort));
    }



    @PostMapping
    ResponseEntity<Extra> create(@RequestBody Extra extra)
    {
       Extra result = extraRepository.save(extra);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Extra> update(@RequestBody Extra extra, @PathVariable Long id)
    {
        if (!extraRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        extra.setId(id);
        extraRepository.save(extra);
        return ResponseEntity.ok(extra);
    }

    @DeleteMapping
    void delete()
    {
        extraRepository.deleteAll();

    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
    {
        extraRepository.deleteById(id);
    }
}
