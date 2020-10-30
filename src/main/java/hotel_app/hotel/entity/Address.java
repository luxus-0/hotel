package hotel_app.hotel.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private Integer postalCode;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    @OneToOne
    private Hotel hotel;

}
