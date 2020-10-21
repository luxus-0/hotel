package hotel_app.hotel.repository;

import hotel_app.hotel.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {



}
