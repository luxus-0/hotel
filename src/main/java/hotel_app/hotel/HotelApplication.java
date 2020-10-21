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





}
