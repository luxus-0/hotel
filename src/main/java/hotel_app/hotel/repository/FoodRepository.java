package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
