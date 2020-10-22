package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;

import java.util.List;

public interface BookingMapper {


    List<BookingDTO> toBookingDTOlist(List<Booking> bookingList);
    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toBookingDTO(Booking booking);




}
