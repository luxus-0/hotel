package hotel_app.hotel;

import hotel_app.hotel.dto.AddressDTO;
import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.dto.CustomerDTO;
import hotel_app.hotel.entity.Address;
import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {


    public static void main(String[] args) {

        SpringApplication.run(HotelApplication.class, args);

    }

    @Bean
    public Address toAdress(AddressDTO addressDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(addressDTO,Address.class);
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());


        return address;
    }

    @Bean
    public AddressDTO toAdressDTO(Address address) {
        ModelMapper modelMapper = new ModelMapper();
        AddressDTO addressDTO = modelMapper.map(address,AddressDTO.class);
                addressDTO.setPostalCode(address.getPostalCode());
                addressDTO.setStreet(address.getStreet());
                addressDTO.setCity(address.getCity());


        return addressDTO;
    }



    @Bean
    public Booking toBooking(BookingDTO bookingDTO) {
        ModelMapper modelMapper = new ModelMapper();
       Booking booking = modelMapper.map(bookingDTO,Booking.class);
        booking.setCreatedDate(bookingDTO.getCreatedDate());
        booking.setNumberBed(bookingDTO.getNumberBed());
        booking.setNumberChildren(bookingDTO.getNumberChildren());
        booking.setNumberAdult(bookingDTO.getNumberAdult());
        booking.setStatus(bookingDTO.getStatus());


        return booking;
    }

    @Bean
    public BookingDTO toBookingDTO(Booking booking) {
        ModelMapper modelMapper = new ModelMapper();
        BookingDTO bookingDTO = modelMapper.map(booking,BookingDTO.class);
        bookingDTO.setCreatedDate(booking.getCreatedDate());
        bookingDTO.setNumberBed(booking.getNumberBed());
        bookingDTO.setNumberChildren(booking.getNumberChildren());
        bookingDTO.setNumberAdult(booking.getNumberAdult());
        bookingDTO.setStatus(booking.getStatus());


        return bookingDTO;
    }

    @Bean
    public Customer toCustomer(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setGender(customerDTO.getGender());
        customer.setEmail(customerDTO.getEmail());


        return customer;
    }



}
