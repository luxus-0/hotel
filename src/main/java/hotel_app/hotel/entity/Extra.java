package hotel_app.hotel.entity;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type;
    private  Category category;
    private Integer cost;
    private String description;

    @OneToOne
    private Room room;

    @OneToOne
    private ReservationDate date;

    @OneToOne
    private Food food;

    void getExtraBreakfast()
    {
        Integer addition = 46;
        Logger log = LoggerFactory.getLogger(Extra.class);
        if(category == Category.Food)
        {
            food.setId(1L);
            food.setName("BREAKFAST");
            log.info("YOU CHOOSE FOOD: " +food.getName());
        }
        if(room.getPersonNumber() == 2)
        {
            room.setPersonNumber(2);
            log.info("NUMBER PERSON: "+room.getPersonNumber());

        }
        if(date.totalDayReservation() > 0)
        {
            for(int i = 0; i <= date.totalDayReservation();i++)
            {
                date.setId(1L);
                date.setCheckInDate(LocalDate.now());
                date.setCheckOutDate(date.getCheckOutDate());

                log.info("TOTAL DAY RESERVATION: "+date.totalDayReservation());
            }
        }

        cost = date.totalDayReservation() * addition;
        log.info("TOTAL COST FOR BREAKFAST: " +cost);

    }

    void getExtraBeds() {
        if(room.getBeds() > 0 && room.getAvailable())
        {
            Logger log = LoggerFactory.getLogger(Extra.class);
            log.info("ADD EXTRA BEDS");
            Scanner sc = new Scanner(System.in);
            Integer add= sc.nextInt();
            Integer allBeds = room.getBeds()+add;
            log.info("EXTRA BEDS: " +add);
            log.info("All BEDS: " +allBeds);

        }
    }
}
