package hotel_app.hotel;

import hotel_app.hotel.dto.AddressDTO;
import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.dto.CustomerDTO;
import hotel_app.hotel.entity.Address;
import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {


    public static void main(String[] args) {

        SpringApplication.run(HotelApplication.class, args);

    }

    @Bean
    public ModelMapper adressMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Address, AddressDTO>() {
            @Override
            protected void configure() {
                map().setCity(source.getCity());
                map().setStreet(source.getStreet());
                map().setPostalCode(source.getPostalCode());
            }
        });

        return modelMapper;
    }

    @Bean
    public ModelMapper adressMapper2() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<AddressDTO, Address>() {
            @Override
            protected void configure() {
                map().setCity(source.getCity());
                map().setStreet(source.getStreet());
                map().setPostalCode(source.getPostalCode());
            }
        });

        return modelMapper;
    }

    @Bean
    public ModelMapper customerMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Customer, CustomerDTO>() {
            @Override
            protected void configure() {
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setGender(source.getGender());
                map().setEmail(source.getEmail());
            }
        });

        return modelMapper;
    }

    @Bean
    public ModelMapper customerMapper2() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CustomerDTO, Customer>() {
            @Override
            protected void configure() {
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setGender(source.getGender());
                map().setEmail(source.getEmail());
            }
        });

        return modelMapper;
    }

    @Bean
    public ModelMapper bookingMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Booking, BookingDTO>() {
            @Override
            protected void configure() {
                map().setCreatedDate(source.getCreatedDate());
                map().setNumberBed(source.getNumberBed());
                map().setNumberChildren(source.getNumberChildren());
                map().setNumberAdult(source.getNumberAdult());
                map().setStatus(source.getStatus());
            }
        });

        return modelMapper;
    }

    @Bean
    public ModelMapper bookingMapper2() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<BookingDTO, Booking>() {
            @Override
            protected void configure() {
                map().setCreatedDate(source.getCreatedDate());
                map().setNumberBed(source.getNumberBed());
                map().setNumberChildren(source.getNumberChildren());
                map().setNumberAdult(source.getNumberAdult());
                map().setStatus(source.getStatus());

            }
        });

        return modelMapper;
    }



}
