package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }
    @GetMapping("/addresses")
    @ApiOperation(value = "find address")
    public List<Address> getAddress()
    {
        return addressService.findAddress();
    }


    @GetMapping("/addresses/{id}")
    @ApiOperation(value = "find by id")
    public Address getAddressById(@RequestParam("id") Long id)
    {
        return addressService.findAddressById(id);
    }

    @GetMapping("/addresses/{streetNumber}")
    @ApiOperation(value = "find by streetNumber")
    public List<Address> getAddressByStreetNumber(@RequestParam("streetNumber") Integer streetNumber)
    {
        return addressService.findAddressByStreetNumber(streetNumber);
    }

    @GetMapping("/addresses/{apartmentNumber}")
    @ApiOperation(value = "find by apartmentNumber")
    public List<Address> getAddressByApartmentNumber(@RequestParam("apartmentNumber") Integer apartmentNumber)
    {
        return addressService.findAddressByApartmentNumber(apartmentNumber);
    }


    @GetMapping("/addresses/{postalCode}")
    @ApiOperation(value = "find by postalCode")
    public List<Address> getAddressByPostalCode(@RequestParam("postalCode") String postalCode)
    {
        return addressService.findAddressByPostalCode(postalCode);
    }


    @GetMapping("/addresses/{city}")
    @ApiOperation(value = "find by city")
    public List<Address> getAddressByCity(@RequestParam("city") String city)
    {
        return addressService.findAddressByCity(city);
    }

    @GetMapping("/addresses/{country}")
    @ApiOperation(value = "find by country")
    public List<Address> getAddressByCountry(@RequestParam("country") String country)
    {
        return addressService.findAddressByCountry(country);
    }

    @PostMapping
    @ApiOperation(value = "save address")
    public Address addAddress(@RequestBody Address address)
    {
        return addressService.saveAddress(address);
    }

    @PutMapping("/addresses/{id]")
    @ApiOperation(value = "update address")
    public Address updateAddress(@RequestBody Address address,@RequestParam("id") Long id)
    {
        return addressService.updateAddress(address,id);
    }

    @DeleteMapping
    @ApiOperation(value = "delete address")
    public void deleteAddress()
    {
        addressService.deleteAddress();
    }

    @DeleteMapping("/addresses/{id}")
    @ApiOperation(value = "delete id")
    public void deleteAddress(@RequestParam("id") Long id)
    {
        addressService.deleteAddressById(id);
    }



}
