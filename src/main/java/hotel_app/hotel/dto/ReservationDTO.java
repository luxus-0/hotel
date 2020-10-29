package hotel_app.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private LocalDate createdDate;
    private  Integer numberChildren;
    private  Integer numberAdult;
    private  Integer numberBed;


}
