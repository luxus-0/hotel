package lukasz.nowogorski.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer stars;
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime checkIn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime earlyCheckIn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime lateCheckIn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime checkOut;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime LateCheckOut;

    private BigDecimal lateCheckoutFee;

    @OneToOne
    private Address address;


    public Hotel() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStars() {
        return stars;
    }

    public String getEmail() {
        return email;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getEarlyCheckIn() {
        return earlyCheckIn;
    }

    public LocalTime getLateCheckIn() {
        return lateCheckIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public LocalTime getLateCheckOut() {
        return LateCheckOut;
    }

    public Address getAddress() {
        return address;
    }

    public BigDecimal getLateCheckoutFee() {
        return lateCheckoutFee;
    }
}
