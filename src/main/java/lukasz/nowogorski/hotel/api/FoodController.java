package lukasz.nowogorski.hotel.api;

import lombok.AllArgsConstructor;
import lukasz.nowogorski.hotel.model.Employee;
import lukasz.nowogorski.hotel.model.Food;
import lukasz.nowogorski.hotel.repository.FoodRespository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class FoodController {

    private final FoodRespository foodRepository;

    @GetMapping("/foods")
    public List<Food> getFood()
    {
        return foodRepository.findAll();
    }

    @GetMapping("/foods/{id}")
    public Optional<Food> getFoodById(@PathVariable Long id)
    {
        return foodRepository.findById(id);
    }

    @PostMapping("/foods")
    public Food saveFood(@RequestBody Food food)
    {
        return foodRepository.save(food);
    }

    @PutMapping("/foods/{id]")
    public Employee updateFood(@RequestBody Food food,@PathVariable Long id)
    {
        return foodRepository.updateFood(food,id);
    }

    @DeleteMapping("/foods")
    public void deleteFood()
    {
        foodRepository.deleteAll();
    }

    @DeleteMapping("/foods/{id}")
    public void deleteFood(@PathVariable Long id)
    {
        foodRepository.deleteById(id);
    }
}
