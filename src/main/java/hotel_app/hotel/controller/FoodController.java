package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Food;
import hotel_app.hotel.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @GetMapping
    ResponseEntity<List<Food>> read()
    {
        return ResponseEntity.ok(foodRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Food> read(@PathVariable Long id)
    {

        return foodRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Food>> read(@PathVariable Pageable page)
    {
        return ResponseEntity.ok(foodRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Food>> read(@PathVariable Sort sort)
    {
        return ResponseEntity.ok(foodRepository.findAll(sort));
    }



    @PostMapping
    ResponseEntity<Food> create(@RequestBody Food food)
    {
        Food result = foodRepository.save(food);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    ResponseEntity<Food> update(@RequestBody Food food, @PathVariable Long id)
    {
        if (!foodRepository.existsById(id))
        {
            ResponseEntity.notFound().build();
        }
        food.setId(id);
        foodRepository.save(food);
        return ResponseEntity.ok(food);
    }

    @DeleteMapping
    void delete()
    {
        foodRepository.deleteAll();

    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id)
    {
        foodRepository.deleteById(id);
    }
}
