package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {


    List<Address> findRegionNameById(Long id);
}
