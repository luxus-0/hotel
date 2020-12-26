package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.Employee;
import lukasz.nowogorski.hotel.model.Food;
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
