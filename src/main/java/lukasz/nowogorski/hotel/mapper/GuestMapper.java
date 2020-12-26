package lukasz.nowogorski.hotel.mapper;

import lukasz.nowogorski.hotel.model.Guest;
import lukasz.nowogorski.hotel.dto.GuestDto;

public interface GuestMapper {

    Guest guestDtoToGuest(GuestDto guestDto);
    GuestDto guestToGuestDto(Guest guest);
}
