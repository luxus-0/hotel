package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Room;
import lukasz.nowogorski.domain.model.RoomStandard;
import lukasz.nowogorski.domain.model.RoomType;
import lukasz.nowogorski.domain.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    @ApiOperation(value = "find rooms")
    public List<Room> getroom()
    {
        return roomService.findRoom();
    }


    @GetMapping("/rooms/{id}")
    @ApiOperation(value = "find by id")
    public Room getRoomById(@PathVariable("id") Long id)
    {
        return roomService.findRoomById(id);
    }

    @GetMapping("/rooms/{roomNumber}")
    @ApiOperation(value = "find by roomNumber")
    public List<Room> getRoomByRoomNumber(@PathVariable("roomNumber") Long roomNumber)
    {
        return roomService.findRoomByRoomNumber(roomNumber);
    }

    @GetMapping("/rooms/{floor}")
    @ApiOperation(value = "find by floor")
    public List<Room> getRoomByFloor(@PathVariable("floor") Long floor)
    {
        return roomService.findRoomByFloor(floor);
    }

    @GetMapping("/rooms/{beds}")
    @ApiOperation(value = "find by beds")
    public List<Room> getRoomByBeds(@PathVariable("beds") Long beds)
    {
        return roomService.findRoomByBeds(beds);
    }


    @GetMapping("/rooms/{peopleNumber}")
    @ApiOperation(value = "find by peopleNumber")
    public List<Room> getRoomByPeopleNumber(@PathVariable("peopleNumber") Long peopleNumber)
    {
        return roomService.findRoomByPeopleNumber(peopleNumber);
    }

    @GetMapping("/rooms/{roomStandard}")
    @ApiOperation(value = "find by roomStandard")
    public List<Room> getRoomByRoomStandard(@PathVariable("roomStandard") RoomStandard roomStandard)
    {
        return roomService.findRoomByRoomStandard(roomStandard);
    }

    @GetMapping("/rooms/{priceForNight}")
    @ApiOperation(value = "find by priceForNight")
    public List<Room> getRoomByPriceForNight(@PathVariable("roomStandard") Float priceForNight)
    {
        return roomService.findRoomByPriceForNight(priceForNight);
    }

    @GetMapping("/rooms/{roomType}")
    @ApiOperation(value = "find by roomType")
    public List<Room> getRoomByRoomType(@PathVariable("roomStandard") RoomType roomType)
    {
        return roomService.findRoomByRoomType(roomType);
    }

    @GetMapping("/rooms/{status}")
    @ApiOperation(value = "find by status")
    public List<Room> getRoomByStatus(@PathVariable("roomStandard") String status)
    {
        return roomService.findRoomByStatus(status);
    }

    @PostMapping("/rooms")
    @ApiOperation(value = "save room")
    public Room addRoom(@RequestBody Room room)
    {
        return roomService.saveRoom(room);
    }

    @PutMapping("/rooms/{id]")
    @ApiOperation(value = "update room")
    public Room updateRoom(@RequestBody Room room,@PathVariable("id") Long id)
    {
        return roomService.updateRoom(room,id);
    }

    @DeleteMapping("/rooms")
    @ApiOperation(value = "delete room")
    public void deleteRoom()
    {
        roomService.deleteRoom();
    }

    @DeleteMapping("/rooms/{id}")
    @ApiOperation(value = "delete id")
    public void deleteRoom(@PathVariable("id") Long id)
    {
        roomService.deleteRoomById(id);
    }
}
