package lukasz.nowogorski.repository;

import lukasz.nowogorski.model.Employee;
import lukasz.nowogorski.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRespository extends JpaRepository<Food,Long> {

    @Modifying
    @Query(value = "UPDATE Food f SET f.id = ?1 WHERE f.id = ?1")
    Employee updateFood(Food food, Long id);
}
