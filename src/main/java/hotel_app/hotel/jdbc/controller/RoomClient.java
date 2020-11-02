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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

@GetMapping("/rooms/{price}")
public String getRoomByAvailable(@PathVariable("available") Boolean available) throws JsonProcessingException {
    return selectRoomQuery.getAvailable(available);
    }

@PostMapping("/rooms")
public ResponseEntity<HttpStatus> addRoom(@RequestBody Room room)
{
    return insertRoomQuery.addRoom(room);
}

@PutMapping("/rooms/{id}")
public void updateRoom(@RequestBody Room room,@PathVariable("id") Long id)
{
    updateRoomQuery.updateRoom(room,id);
}

@PutMapping("/rooms")
public void deleteRoom(@RequestBody Room room,@PathVariable("id") Long id)
{
    deleteRoomQuery.deleteRoom(room,id);
}

@PutMapping("/rooms")
public void deleteRoom(@PathVariable("id") Long id)
{
        deleteRoomQuery.deleteRoomById(id);
}

@PutMapping("/rooms/{beds}")
public void deleteBeds(@PathVariable("beds") Integer beds) {
       deleteRoomQuery.deleteRoombyBeds(beds);
    }

@PutMapping("/rooms/{price}")
public void deletePrice(@PathVariable("price") Double price) {
       deleteRoomQuery.deleteRoomByPrice(price);
    }

@PutMapping("/rooms/{priceForNight}")
public void deletePriceForNight(@PathVariable("priceForNight") Double priceForNight)
    {
        deleteRoomQuery.deleteRoomByPriceForNight(priceForNight);
    }

@PutMapping("/rooms/{available}")
public void deleteAvailable(@PathVariable("available") Boolean available) {
       deleteRoomQuery.deleteRoomByAvailable(available);
    }

@PutMapping("/rooms/{personNumber}")
public void deleteRoomByPersonNumber(@PathVariable("personNumber") Integer personNumber) {
       deleteRoomQuery.deleteRoomByPersonNumber(personNumber);
    }

public void deleteRoomByRoomType(@PathVariable("roomType") RoomType roomType) {
       deleteRoomQuery.deleteRoomByRoomType(roomType);
    }



}
