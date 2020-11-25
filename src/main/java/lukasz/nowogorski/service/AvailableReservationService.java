package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Log4j2
public class AvailableReservationService {

    private final LocalDate checkIn = LocalDate.now();

    public boolean availableReservation(Integer beds, Integer numberPeople) {

        if(beds > numberPeople)
        {
            log.info("You have free room");
            Map<Integer,Integer> number = new HashMap<>();
            number.put(beds, numberPeople);
            for(Integer nr : number.values())
            {
                log.info(nr.toString());
            }

        }
        else if(beds.equals(numberPeople))
        {
            log.info("you haven't any room in hotel");
        }
        else {
            throw new RuntimeException("Error beds is less than number people");
        }
        return true;
        }


        public Long numberDaysReservation(Integer add)
        {
            LocalDate checkOut = checkIn.plusDays(add);
            long days = ChronoUnit.DAYS.between(checkIn, checkOut);
            log.info("DAYS RESERVATION: " + days);
            return days;
        }

        public void allMonthReservation () {
            List<Month> months = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                months.add(Month.of(i));
                log.info("Month: " + months);
            }
        }


        public void validateMonth ()
        {
            List<Month> firstMonth = new ArrayList<>();
            List<Month> lastMonth = new ArrayList<>();

            firstMonth.add(1, Month.JANUARY);
            lastMonth.add(12, Month.DECEMBER);

            if (firstMonth.size() < lastMonth.size()) {
                log.info("Months reservation are not equal");
                List.of(firstMonth).forEach(System.out::println);
                List.of(lastMonth).forEach(System.out::println);
            } else if (firstMonth.size() == lastMonth.size()) {
                log.info("months reservation are equal");
                log.info(firstMonth);
                log.info(lastMonth);
            } else {
                log.info("");
            }
        }

        public List<Room> findRoomByBeds(Integer beds)
        {
            RoomCreatorService create = new RoomCreatorService();
            List<Room> allBeds = new ArrayList<>();
            allBeds.add(create.createRoomByBeds(beds));
            if (beds == null) {
                log.info("You have any beds: " +allBeds);
            } else {

                for(Room all : allBeds)
                {
                    log.info("All beds: " +all.getBeds());
                }
                allBeds.stream().filter(p -> p.getBeds() >=1).limit(15)
                        .forEach(System.out::println);
            }

            return allBeds;
        }

    public List<Room> findRoomByNumberPeople(Integer numberPeople)
    {
        RoomCreatorService create = new RoomCreatorService();
        List<Room> people = new ArrayList<>();
        people.add(create.createRoomByNumberPeople(numberPeople));
        if (numberPeople == null) {
            log.info("You haven't people in room: " +people);
        } else {

            for(Room all : people)
            {
                System.out.println("All people: " +all.getPeopleNumber());
            }
            people.stream().filter(p -> p.getPeopleNumber() >= 1).limit(15)
                    .forEach(System.out::println);
        }

        return people;
    }

}
