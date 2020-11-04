package hotel_app.hotel.jdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.jdbc.command.SelectRoomQuery;
import hotel_app.hotel.jdbc.model.Room;
import hotel_app.hotel.jdbc.query.DeleteRoomQuery;
import hotel_app.hotel.jdbc.query.InsertRoomQuery;
import hotel_app.hotel.jdbc.query.UpdateRoomQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class RoomClient {

    private final SelectRoomQuery selectRoomQuery;
    private final InsertRoomQuery insertRoomQuery;
    private final UpdateRoomQuery updateRoomQuery;
    private final DeleteRoomQuery deleteRoomQuery;

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

@GetMapping("/rooms/{available}")
public String getRoomByAvailable(@PathVariable("available") Boolean available) throws JsonProcessingException {
    return selectRoomQuery.getAvailable(available);
    }

@PostMapping("/rooms")
public ResponseEntity<HttpStatus> addRoom(@RequestBody Room room)
{
    return insertRoomQuery.addRoom(room);
}

@PutMapping("/rooms/{id}")
public void updateRoom(@RequestBody Room room)
{
    updateRoomQuery.updateRoom(room);
}

@DeleteMapping("/rooms")
public ResponseEntity<HttpStatus> deleteRoom(@RequestBody Room room)
{
    return deleteRoomQuery.deleteRoom(room);
}

@DeleteMapping("/rooms/{id}")
public ResponseEntity<HttpStatus> deleteRoom(@PathVariable("id") Long id)
{
        return deleteRoomQuery.deleteRoomById(id);
}

@DeleteMapping("/rooms/{beds}")
public ResponseEntity<HttpStatus> deleteBeds(@PathVariable("beds") Integer beds) {
       return deleteRoomQuery.deleteRoombyBeds(beds);
    }

@DeleteMapping("/rooms/{price}")
public ResponseEntity<HttpStatus> deletePrice(@PathVariable("price") Double price) {
       return deleteRoomQuery.deleteRoomByPrice(price);
    }

@DeleteMapping("/rooms/{priceForNight}")
public ResponseEntity<HttpStatus> deletePriceForNight(@PathVariable("priceForNight") Double priceForNight)
    {
       return deleteRoomQuery.deleteRoomByPriceForNight(priceForNight);
    }

@DeleteMapping("/rooms/{available}")
public ResponseEntity<HttpStatus> deleteAvailable(@PathVariable("available") Boolean available) {
       return deleteRoomQuery.deleteRoomByAvailable(available);
    }

@DeleteMapping("/rooms/{personNumber}")
public ResponseEntity<HttpStatus> deleteRoomByPersonNumber(@PathVariable("personNumber") Integer personNumber) {
       return deleteRoomQuery.deleteRoomByPersonNumber(personNumber);
    }

@DeleteMapping("/rooms/{roomType}")
public ResponseEntity<HttpStatus> deleteRoomByRoomType(@PathVariable("roomType") RoomType roomType) {
       return deleteRoomQuery.deleteRoomByRoomType(roomType);
    }



}
