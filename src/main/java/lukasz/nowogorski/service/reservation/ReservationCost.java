package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationCost {

   private final ReservationDate date;

    public double getReservationCost(long hours)
    {
        LocalDateTime cost = date.getCheckOutDate().plusHours(hours);
        return cost.getHour() * getPaymentForHour();
    }

    public double getPaymentForHour()
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
