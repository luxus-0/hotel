package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;
import org.modelmapper.ModelMapper;

public class BookingMapperImpl implements BookingMapper {

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
}
