package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;
import org.modelmapper.ModelMapper;

public class BookingMapperImpl implements BookingMapper {



    public Booking toBooking(BookingDTO bookingDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Booking booking = modelMapper.map(bookingDTO,Booking.class);
        booking.setCustomer(bookingDTO.getCustomer());
        booking.setExtras(bookingDTO.getExtras());
        booking.setRoom(bookingDTO.getRoom());


        return booking;
    }

    public BookingDTO toBookingDTO(Booking booking) {
        ModelMapper modelMapper = new ModelMapper();
        BookingDTO bookingDTO = modelMapper.map(booking,BookingDTO.class);
        bookingDTO.setCustomer(booking.getCustomer());
        bookingDTO.setExtras(booking.getExtras());
        bookingDTO.setRoom(booking.getRoom());


        return bookingDTO;
    }
    
}
