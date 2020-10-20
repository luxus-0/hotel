package hotel_app.hotel.Entity;

import hotel_app.hotel.Entity.PaymentStatus;
import hotel_app.hotel.Entity.CardType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.YearMonth;

@Entity
@Getter
public class Payment {

    @Id
    private Long paymentId;
    private CardType cardType;
    private Long numberCard;
    private String country;
    private Integer last4CreditCardDigits;
    private YearMonth cardExpiry;
    private PaymentStatus paymentStatus;


}
