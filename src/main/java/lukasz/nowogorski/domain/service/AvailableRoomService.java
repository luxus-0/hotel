package lukasz.nowogorski.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.domain.model.Room;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
@Log4j2
public class AvailableRoomService {

    private final AvailableReservationService reservationService;

    public void freeRoom(Integer beds,Integer peopleNumber)
    {

            if(reservationService.availableReservation(beds,peopleNumber))
             {
                if(reservationService.findRoomByNumberPeople(peopleNumber) > 0)
                {
                     Random r = new Random();
                     int lowerBound = 1;
                     int upperBound = 11;
                     int result = r.nextInt(upperBound-lowerBound) + lowerBound;
                     log.info("RESULT FREE ROOM: " +result);
                 }
             }
    }
}