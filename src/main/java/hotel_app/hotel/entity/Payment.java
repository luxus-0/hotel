package hotel_app.hotel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.YearMonth;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CardType cardType;
    private Long AccountNumber;
    private String country;
    private Integer last4CreditCardDigits;
    private YearMonth cardExpiry;


    public double getPaymentLateCheckOut()
    {
        double fee = 40.23;
        Room room = new Room();
        Payment payment = new Payment();
        Reservation reserve = new Reservation();
        return room.getTotalCostRoom() + (reserve.getNumberChildren() + reserve.getNumberAdult()) + fee;

    }


}
