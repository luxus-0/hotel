package hotel_app.hotel.service;

import hotel_app.hotel.entity.Customer;
import hotel_app.hotel.entity.ReservationDates;
import hotel_app.hotel.entity.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private Room room;
    private final List<Customer> customerList = new ArrayList<Customer>();
   private final Logger log = LoggerFactory.getLogger(RoomService.class);

   public void getRoom()
   {
       customerList.stream()
               .filter(Customer -> Customer.getId() > 0).forEach(System.out::println);
   }

    public boolean isRoomFull()
    {
        boolean full = customerList.size() > room.getBeds();
        log.info("Room is full? : " +full);
        return full;
    }

    public boolean isRoomEmpty()
    {
        boolean empty = customerList.size() < room.getBeds();
        log.info("Room is full? " +empty);
        return empty;
    }

    public void getTotalCost()
    {
        ReservationDates dates = new ReservationDates();

    }

}
