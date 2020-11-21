package lukasz.nowogorski.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.domain.model.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@AllArgsConstructor
@Log4j2
public class AvailableReservationService {

    private final LocalDate checkIn = LocalDate.now();
    private final RoomCreatorService service;
    private LocalDate checkOut;


    public boolean availableReservation(Integer beds, Integer numberPeople) {
        Integer availableBeds = findRoomByBeds(beds);
        Integer availablePeople = findRoomByNumberPeople(numberPeople);
        if(availableBeds > availablePeople)
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
        return availableBeds > availablePeople;
        }


        public Long numberDaysReservation(Integer add)
        {
            checkOut = checkIn.plusDays(add);
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

        public Integer findRoomByBeds (Integer beds)
        {
            Room room = service.createRoomByBeds(beds);
            if (room.getBeds() == 0) {
                log.info("ERROR YOU HAVEN'T ANY BEDS");
            } else {
                log.info("YOU HAVE BEDS");
            }

            return beds;
        }

        public Integer findRoomByNumberPeople(Integer peopleNumber)
        {
            Room room = service.createRoomByNumberPeople(peopleNumber);
            if (room.getPeopleNumber() == 0) {
                log.info("ROOM IS FREE");
            } else {
                log.info("ROOM IS BUSY: " + room.getPeopleNumber() + " PEOPLE");
            }

            return peopleNumber;
        }

    }
