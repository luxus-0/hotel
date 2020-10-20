package hotel_app.hotel.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private Long id;
    private String name;
    private String surname;
    private Integer idDocument;
    private String gender;
    private Long telephone;
    private String email;
    private String preferences;
    private String password;



}
