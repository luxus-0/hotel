package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.AddressDTO;
import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.dto.CustomerDTO;
import hotel_app.hotel.entity.Address;
import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public interface AddressMapper {

    Address toAdress(AddressDTO addressDTO);
    AddressDTO toAdressDTO(Address address);







}
