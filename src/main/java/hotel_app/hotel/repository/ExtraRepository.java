package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<Extra,Long> {
}
