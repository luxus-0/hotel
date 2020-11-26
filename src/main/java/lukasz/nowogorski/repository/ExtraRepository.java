package lukasz.nowogorski.repository;

import lukasz.nowogorski.model.Employee;
import lukasz.nowogorski.model.Extra;
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
