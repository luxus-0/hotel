package hotel_app.hotel.Repository;

import hotel_app.hotel.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {


    List<Address> findRegionNameById(Long id);
}
