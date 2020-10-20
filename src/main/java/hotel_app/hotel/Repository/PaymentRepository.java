package hotel_app.hotel.Repository;

import hotel_app.hotel.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {



}
