package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


    List<Address> findRegionNameById(Long id);
}
