package hotel_app.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.YearMonth;

@Entity
public class Payment {

    @Id
    private Long id;

    @NotNull(message = "Card Type cannot be null")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @NotNull(message = "Number account cannot be null")
    @Size(min = 0,max = 26)
    private Long AccountNumber;

    @NotNull(message = "Country cannot be null")
    private String country;

    @NotNull(message = "Last 4 Number Credit Card cannot be null")
    private Integer last4CreditCardDigits;

    @NotNull(message = "Card expriration cannot be null")
    private YearMonth cardExpiry;

    @NotNull(message = "Payment status cannot be null")
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

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
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
