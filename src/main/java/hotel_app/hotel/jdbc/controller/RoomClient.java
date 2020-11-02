package hotel_app.hotel.jdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hotel_app.hotel.jdbc.command.SelectRoomQuery;
import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class RoomClient {

    private final SelectRoomQuery selectRoomQuery;

@GetMapping("/rooms")
public String getRooms() throws JsonProcessingException {
    return selectRoomQuery.get();
}

@GetMapping("/rooms/{id}")
public String getRoomById(@PathVariable("id") Long id) throws JsonProcessingException {
        return selectRoomQuery.getId(id);
}

@GetMapping("/rooms/{beds}")
public String getRoomByBeds(@PathVariable("beds") Integer beds) throws JsonProcessingException {
    return selectRoomQuery.getBeds(beds);
}

@GetMapping("/rooms/{personNumber}")
public String getRoomByPersonNumber(@PathVariable("personNumber") Integer personNumber) throws JsonProcessingException {
    return selectRoomQuery.getPersonNumber(personNumber);
}

@GetMapping("/rooms/{priceForNight}")
public String getRoomByPriceForNight(@PathVariable("priceForNight") Double priceForNight) throws JsonProcessingException {
    return selectRoomQuery.getPriceForNight(priceForNight);
}

@GetMapping("/rooms/{price}")
public String getRoomByPrice(@PathVariable("price") Double price) throws JsonProcessingException {
    return selectRoomQuery.getPrice(price);
    }

@GetMapping("/rooms/{price}")
public String getRoomByAvailable(@PathVariable("available") Boolean available) throws JsonProcessingException {
    return selectRoomQuery.getAvailable(available);
    }

@PostMapping("/rooms")
public void addRoom(@RequestBody Room room)
{

}


}
