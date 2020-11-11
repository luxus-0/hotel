package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.model.Guest;
import lukasz.nowogorski.domain.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    @ApiOperation(value = "find guest")
    public List<Guest> getGuest()
        {
            return guestService.findGuest();
        }

    @GetMapping("/guests/{id}")
    @ApiOperation(value = "find by id")
    public Guest getGuestById(@PathVariable("id") Long id)
        {
            return guestService.findGuestById(id);
        }

    @GetMapping("/guests/{name}")
    @ApiOperation(value = "find by name")
    public List<Guest> getGuestByName(@PathVariable("name") String name)
    {
        return guestService.findGuestByName(name);
    }

    @GetMapping("/guests/{secondName}")
    @ApiOperation(value = "find by secondName")
    public List<Guest> getGuestBySecondName(@PathVariable("secondName") String secondName)
    {
        return guestService.findGuestBySecondName(secondName);
    }


    @GetMapping("/guests/{surname}")
    @ApiOperation(value = "find by surname")
    public List<Guest> getGuestBySurname(@PathVariable("surname") String surname)
    {
        return guestService.findGuestBySurname(surname);
    }

    @GetMapping("/guests/{gender}")
    @ApiOperation(value = "find by gender")
    public List<Guest> getGuestByGender(@PathVariable("gender") Gender gender)
    {
        return guestService.findGuestByGender(gender);
    }

    @GetMapping("/guests/{pesel}")
    @ApiOperation(value = "find by pesel")
    public List<Guest> getGuestByPesel(@PathVariable("pesel") Long pesel)
    {
        return guestService.findGuestByPesel(pesel);
    }

    @GetMapping("/guests/{nationality}")
    @ApiOperation(value = "find by nationality")
    public List<Guest> getGuestByNationality(@PathVariable("nationality") String nationality)
    {
        return guestService.findGuestByNationality(nationality);
    }

    @GetMapping("/guests/{dateOfBirth}")
    @ApiOperation(value = "find by dateOfBirth")
    public List<Guest> getGuestByDateOfBirth(@PathVariable("dateOfBirth") LocalDateTime dateOfBirth)
    {
        return guestService.findGuestByDateOfBirth(dateOfBirth);
    }

    @GetMapping("/guests/{telephone}")
    @ApiOperation(value = "find by telephone")
    public List<Guest> getGuestByTelephone(@PathVariable("telephone") String telephone)
    {
        return guestService.findGuestByTelephone(telephone);
    }

    @GetMapping("/guests/{email}")
    @ApiOperation(value = "find by email")
    public List<Guest> getGuestByEmail(@PathVariable("email") String email)
    {
        return guestService.findGuestByEmail(email);
    }

    @PostMapping("/guests")
    @ApiOperation(value = "save guest")
    public Guest addGuest(@RequestBody Guest guest)
    {
        return guestService.saveGuest(guest);
    }

    @PutMapping("/guests/{id]")
    @ApiOperation(value = "update guest")
    public Guest updateGuest(@RequestBody Guest guest,@PathVariable("id") Long id)
    {
        return guestService.updateGuest(guest,id);
    }

    @DeleteMapping("/guests")
    @ApiOperation(value = "delete guest")
    public void deleteGuest()
    {
        guestService.deleteGuest();
    }

    @DeleteMapping("/guests/{id}")
    @ApiOperation(value = "delete id")
    public void deleteGuest(@PathVariable("id") Long id)
        {
            guestService.deleteGuestById(id);
        }
}
