package hotel_app.hotel.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

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
