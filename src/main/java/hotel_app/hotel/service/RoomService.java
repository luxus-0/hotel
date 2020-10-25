package hotel_app.hotel.service;

import hotel_app.hotel.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private Room room;
    private RoomType type;
    private final List<Customer> customerList = new ArrayList<Customer>();
   private final Logger log = LoggerFactory.getLogger(RoomService.class);

   public void getRoom()
   {
       log.info("find room");
       customerList.stream()
               .filter(Customer -> Customer.getId() > 0).forEach(System.out::println);
   }



   public void addRoom(Customer customer)
   {
       customerList.add(customer);
   }

    public boolean isRoomFull()
    {
        log.info("Is room full?");
        boolean full = customerList.size() >= room.getBeds();
        log.info("Room is full? : " +full);
        return full;
    }

    public boolean isRoomEmpty()
    {
        log.info("Is room empty?");
        boolean empty = customerList.size() < room.getBeds();
        log.info("Room is full? " +empty);
        return empty;
    }

    public double getTotalCost()
    {
        log.info("total cost room");
        BookingDate dates = new BookingDate();
        Integer days = dates.totalDays();

        if(days == 0)
        {
            log.error("Total days reservation is null");
        }

        return room.getPriceForNight() * days;
    }

    public Type getRoomType()
    {

        String roomType = type.name();
        switch(roomType) {
            case "ECONOMY":
            case "ECONOMY-PREMIUM":
                return Type.Basic;
            case "BUSINESS":
            case "I CLASS":
                return Type.Premium;
            default:
                log.error("Type room is empty");
        }
        return Type.Basic;
    }

}
