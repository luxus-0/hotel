package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.entity.Customer;
import hotel_app.hotel.entity.Room;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BookingMapperImpl implements BookingMapper {

    @Override
    public List<BookingDTO> toBookingDTOlist(List<Booking> bookingList) {
        ModelMapper modelMapper = new ModelMapper();
        List<BookingDTO> bookingDTOList = new ArrayList<>();

        BookingDTO bookingDTO = new BookingDTO(
                new Room(),new Customer(),new HashSet<>()
        );
        return bookingDTOList;
    }

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
