package lukasz.nowogorski.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.Month.*;

@Service
@AllArgsConstructor
@Log4j2
public class AvailableReservationService {

    private final LocalDate checkIn;
    private final LocalDate checkOut;


    public void availableReservation(LocalDate checkIn, LocalDate checkOut)
    {
        LocalDate yearCheckIn = checkIn.withYear(LocalDate.now().getYear());
        LocalDate yearCheckOut = checkOut.withYear(LocalDate.now().getYear());
        LocalDate daysCheckIn = checkIn.withDayOfMonth(1);
        LocalDate daysCHeckOut = checkIn.plusDays(29);

        if(checkIn.getDayOfMonth() > 15 && checkOut.getDayOfMonth() < 30) {
            Map<Integer, LocalDate> freeDaysInCalendar = new HashMap<>();


            for (int i = 1; i <= 30; i++) {
                for (int j = 15; j <= 30; j++)
                {

                    freeDaysInCalendar.put(i, LocalDate.of(yearCheckIn.getYear(), Month.of(i), j));

                    int days = freeDaysInCalendar.size();

                    log.info("Free days reservation: " +freeDaysInCalendar.toString());
                    log.info("Number Free days reservation: " +days);


                }

            }
        }
    }

    public Long numberDaysReservation()
    {
        return ChronoUnit.DAYS.between(checkIn,checkOut);
    }

    public void allMonthReservation() {
        List<Month> months = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            months.add(Month.of(i));
            log.info("Month: " + months);
        }
    }

    public void allYearReservation()
    {

        for(int z = 0; z < 14; z++)
        {
            LocalDate yearCheckIn = checkIn.withYear(LocalDate.now().getYear());
            LocalDate yearCheckOut = checkOut.withYear(LocalDate.now().getYear());
            LocalDate minMonthCheckIn = yearCheckIn.withMonth(1);
            LocalDate maxMonthCheckIn = yearCheckOut.withMonth(12);
            long allYear = ChronoUnit.YEARS.between(maxMonthCheckIn,minMonthCheckIn);
            log.info("all year reservation : " +allYear);
        }
    }

    public void validateYearCheckInCheckOutReservation()
    {
        LocalDate yearCheckIn = checkIn.withYear(LocalDate.now().getYear());
        LocalDate yearCheckOut = checkOut.withYear(LocalDate.now().getYear());
        if(yearCheckIn == yearCheckOut)
        {
            log.info("Year CHECK IN and year CHECK OUT is the same");
        }
    }

    public void validateMonthCheckInCheckOutReservation()
    {
        allMonthReservation();
        List<Month> firstMonth = new ArrayList<>();
        List<Month> lastMonth = new ArrayList<>();

        firstMonth.add(1, JANUARY);
        lastMonth.add(12,Month.DECEMBER);

        if(firstMonth != lastMonth)
        {
            log.info("Months are not the same");
            List.of(firstMonth).forEach(System.out::println);
            List.of(lastMonth).forEach(System.out::println);
        }
        else {
            log.info("Months are equal");
            log.info(firstMonth);
            log.info(lastMonth);
        }
    }
    public void validateMonthCheckInLessThanMonthCheckOut()
    {

    }

    public void displayCheckIn()
    {
        Set<Month> monthCheckIn = Set.of(JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER);
        Set<Month> monthCheckOut = Set.of(JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER);
        monthCheckIn.stream().filter(p -> p.equals(JANUARY)).forEach(b -> log.info("JANUARY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(FEBRUARY)).forEach(b -> log.info("FEBRUARY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(MARCH)).forEach(b -> log.info("MARCH CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(APRIL)).forEach(b -> log.info("APRIL CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(MAY)).forEach(b -> log.info("MAY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(JUNE)).forEach(b -> log.info("JUNE CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(JULY)).forEach(b -> log.info("JULY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(SEPTEMBER)).forEach(b -> log.info("SEPTEMBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(OCTOBER)).forEach(b -> log.info("OCTOBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(NOVEMBER)).forEach(b -> log.info("NOVEMBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(DECEMBER)).forEach(b -> log.info("DECEMBER CHECK IN"));
    }

    public void displayCheckOut()
    {
        Set<Month> monthCheckIn = Set.of(JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER);
        Set<Month> monthCheckOut = Set.of(JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER);
        monthCheckIn.stream().filter(p -> p.equals(JANUARY)).forEach(b -> log.info("JANUARY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(FEBRUARY)).forEach(b -> log.info("FEBRUARY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(MARCH)).forEach(b -> log.info("MARCH CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(APRIL)).forEach(b -> log.info("APRIL CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(MAY)).forEach(b -> log.info("MAY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(JUNE)).forEach(b -> log.info("JUNE CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(JULY)).forEach(b -> log.info("JULY CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(SEPTEMBER)).forEach(b -> log.info("SEPTEMBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(OCTOBER)).forEach(b -> log.info("OCTOBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(NOVEMBER)).forEach(b -> log.info("NOVEMBER CHECK IN"));
        monthCheckIn.stream().filter(p -> p.equals(DECEMBER)).forEach(b -> log.info("DECEMBER CHECK IN"));
    }


}
