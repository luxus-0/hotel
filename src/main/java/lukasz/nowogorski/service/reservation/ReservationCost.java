package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationCost {

   private final ReservationTime time;
   private final ReservationDate date;

    public double getCostByLateCheckOutTime(LocalTime checkOut,LocalTime lateCheckOut)
    {
        return time.getLateCheckOutTimeByNumbersHours(checkOut,lateCheckOut) * getTaxByLateCheckOut();
    }



    public double getTaxByLateCheckOut()
    {
        List<Double> tax = new ArrayList<>();
        tax.add(12.3);
        tax
                .stream()
                .filter(pay -> pay > 0)
                .forEach(b-> System.out.println("Tax for late hour: " +b));
        return tax.get(0);
    }


}
