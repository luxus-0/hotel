package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "find by id")
    public Address getAddressById(@RequestParam("id") Long id)
    {
        return addressService.findAddressById(id);
    }

    @GetMapping("/{streetNumber}")
    @ApiOperation(value = "find by streetNumber")
    public List<Address> getAddressByStreetNumber(@RequestParam("streetNumber") String streetNumber)
    {
        return addressService.findAddressByStreetNumber(streetNumber);
    }

    @GetMapping("/{apartmentNumber}")
    @ApiOperation(value = "find by apartmentNumber")
    public List<Address> getAddressByApartmentNumber(@RequestParam("apartmentNumber") String apartmentNumber)
    {
        return addressService.findAddressByApartmentNumber(apartmentNumber);
    }


    @GetMapping("/{postalCode}")
    @ApiOperation(value = "find by postalCode")
    public List<Address> getAddressByPostalCode(@RequestParam("postalCode") String postalCode)
    {
        return addressService.findAddressByPostalCode(postalCode);
    }


    @GetMapping("/{city}")
    @ApiOperation(value = "find by city")
    public List<Address> getAddressByCity(@RequestParam("city") String city)
    {
        return addressService.findAddressByCity(city);
    }

    @GetMapping("/{country}")
    @ApiOperation(value = "find by country")
    public List<Address> getAddressByCountry(@RequestParam("country") String country)
    {
        return addressService.findAddressByCountry(country);
    }

    @DeleteMapping
    @ApiOperation(value = "delete address")
    public void deleteAddress()
    {
        addressService.deleteAddress();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete id")
    public void deleteAddress(@RequestParam("id") Long id)
    {
        addressService.deleteAddressById(id);
    }




}
