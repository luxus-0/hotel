package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.AddressDTO;
import hotel_app.hotel.entity.Address;

public interface AddressMapper {

    Address toAdress(AddressDTO addressDTO);
    AddressDTO toAdressDTO(Address address);







}
