package lukasz.nowogorski.mapper;

import lukasz.nowogorski.model.Guest;
import lukasz.nowogorski.dto.GuestDto;

public interface GuestMapper {

    Guest guestDtoToGuest(GuestDto guestDto);
    GuestDto guestToGuestDto(Guest guest);
}
