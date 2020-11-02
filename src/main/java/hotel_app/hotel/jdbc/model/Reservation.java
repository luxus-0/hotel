package hotel_app.hotel.jdbc.model;


import hotel_app.hotel.entity.Room;
import hotel_app.hotel.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {


    private  Long id;
    private LocalDate createdDate;
    private  Integer numberChildren;
    private  Integer numberAdult;
    private  Integer numberBed;
    private String password;




}
