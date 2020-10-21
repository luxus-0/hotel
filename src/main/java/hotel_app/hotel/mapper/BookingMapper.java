package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.BookingDTO;
import hotel_app.hotel.entity.Booking;

public interface BookingMapper {

    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toBookingDTO(Booking booking);




}
