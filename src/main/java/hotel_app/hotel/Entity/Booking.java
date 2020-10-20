package hotel_app.hotel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createdDate;

    private  Integer numberChildren;
    private  Integer numberAdult;
    private  Integer numberBed;
   private  Status status;

   @OneToOne(mappedBy = "booking")
   private Room room;

   @OneToOne(mappedBy = "booking")
   private Payment payment;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "booking_customers",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id")
    )
   private Set<Customer> customer;


    @ManyToMany
    @JoinTable(
            name = "booking_extras",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id", referencedColumnName = "id")
    )
    private Set<Extra> extras;




}
