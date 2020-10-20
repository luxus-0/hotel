package hotel_app.hotel.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class FormOfPayment {

    @Id
    private Long idFormOfPaymnent;
    private String name;

}
