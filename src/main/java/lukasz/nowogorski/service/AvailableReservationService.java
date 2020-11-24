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
    private final RoomCreatorService service;

    public boolean availableReservation(Integer beds, Integer numberPeople) {
        Room availableBeds = findRoomByBeds(beds);
        Room availablePeople = findRoomByNumberPeople(numberPeople);

        if(availableBeds.getBeds() > availablePeople.getPeopleNumber())
        {
            log.info("YOU HAVE FREE ROOM IN HOTEL");
            Map<Integer,Integer> number = new HashMap<>();
            number.put(beds, numberPeople);
            for(Integer nr : number.values())
            {
                log.info(nr.toString());
            }

        }
        else if(availableBeds.equals(availablePeople))
        {
            log.info("YOU HAVEN'T ANY FREE ROOM IN HOTEL");
        }
        else
        {
            throw new RuntimeException("ERROR!!BEDS IS LESS THAN PEOPLE!!");
        }
        return availableBeds.getBeds() > availablePeople.getPeopleNumber();
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
                log.info("MONTHS RESERVATION ARE NOT THE SAME");
                List.of(firstMonth).forEach(System.out::println);
                List.of(lastMonth).forEach(System.out::println);
            } else if (firstMonth.size() == lastMonth.size()) {
                log.info("MONTHS RESERVATION ARE EQUAL");
                log.info(firstMonth);
                log.info(lastMonth);
            } else {
                log.info("");
            }
        }

        public Room findRoomByBeds (Integer beds)
        {
            Room room = service.createRoomByBeds(beds);
           List<Room> allBeds = new ArrayList<>();
            allBeds.add(room);
            if (room.getBeds() == null) {
                log.info("ERROR YOU HAVEN'T ANY BEDS");
            } else {
                allBeds.stream().filter(p -> p.getPeopleNumber() >=1).limit(15)
                        .forEach(System.out::println);
                log.info("YOU HAVE BEDS");
            }

            return room;
        }

        public Room findRoomByNumberPeople(Integer peopleNumber)
        {
            Room room = service.createRoomByNumberPeople(peopleNumber);
            List<Room> allPeople = new ArrayList<>();
            allPeople.add(room);
            if (room.getPeopleNumber() == 0) {
                log.info("ROOM IS FREE");

            } else {
                allPeople.stream().filter(p -> p.getPeopleNumber() >=1).limit(15)
                        .forEach(System.out::println);
                log.info("ROOM IS BUSY: " + room.getPeopleNumber() + " PEOPLE");
            }

            return room;
        }

    }
