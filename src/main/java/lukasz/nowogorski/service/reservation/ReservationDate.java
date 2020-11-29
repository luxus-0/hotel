package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class ReservationDate {


    public LocalDate getCheckInDate()
    {
        LocalDate now = LocalDate.now();
        List<LocalDate> checkInDate = new ArrayList<>();
        checkInDate.add(now);
        checkInDate
                .stream()
                .filter(p -> p.equals(now))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        return now;
    }

    public LocalDate getCheckOutDate(Long numberDays)
    {
        LocalDate checkOutDate = getCheckInDate().plusDays(numberDays);
        List<LocalDate> checkOut = List.of(checkOutDate);
        checkOut
                .stream()
                .filter(check -> check.isAfter(getCheckInDate()))
                .collect(Collectors.toList())
                .forEach(b -> System.out.println("Check out date: " +b));
        return checkOutDate;
    }

    public void getReservationDate()
    {
        for(long i = 0; i < 30; i++) {
            LocalDate checkInDate = getCheckInDate();
            LocalDate checkOutDate = getCheckOutDate(i);

            System.out.println( "Year check in: " +checkInDate.getYear()
                    +"\nMonth check in: " +checkInDate.getMonth()
                    +"\nDay check in: "+ checkInDate.getDayOfMonth());

            System.out.println( "Year check out: " +checkOutDate.getYear()
                              +"\nMonth check out: " +checkOutDate.getMonth()
                              +"\nDay check out: "+ checkOutDate.getDayOfMonth());
        }
    }
}
