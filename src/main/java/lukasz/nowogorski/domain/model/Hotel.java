package lukasz.nowogorski.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

}
