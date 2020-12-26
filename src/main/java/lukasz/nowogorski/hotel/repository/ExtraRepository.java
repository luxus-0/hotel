package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.Employee;
import lukasz.nowogorski.hotel.model.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<Extra,Long> {

    @Modifying
    @Query(value = "UPDATE Food f SET f.id = ?1 WHERE f.id = ?1")
    Employee updateExtra(Extra extra, Long id);
}
