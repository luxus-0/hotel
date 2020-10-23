package hotel_app.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.YearMonth;

@Entity
public class Payment {

    @Id
    private Long id;
    private CardType cardType;
    private Long numberCard;
    private String country;
    private Integer last4CreditCardDigits;
    private YearMonth cardExpiry;
    private PaymentStatus paymentStatus;

    @OneToOne
    private Booking booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLast4CreditCardDigits() {
        return last4CreditCardDigits;
    }

    public void setLast4CreditCardDigits(Integer last4CreditCardDigits) {
        this.last4CreditCardDigits = last4CreditCardDigits;
    }

    public YearMonth getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(YearMonth cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
