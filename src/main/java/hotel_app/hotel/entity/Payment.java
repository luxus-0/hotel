package hotel_app.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.YearMonth;

@Entity
public class Payment {

    @Id
    private Long paymentId;
    private CardType cardType;
    private Long numberCard;
    private String country;
    private Integer last4CreditCardDigits;
    private YearMonth cardExpiry;
    private PaymentStatus paymentStatus;

    @OneToOne
    private Booking booking;


}
