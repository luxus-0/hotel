package lukasz.nowogorski.mapper;

import lukasz.nowogorski.domain.model.Employee;
import lukasz.nowogorski.domain.model.Guest;
import lukasz.nowogorski.dto.EmployeeDto;
import lukasz.nowogorski.dto.GuestDto;

public interface GuestMapper {

    Guest guestDtoToGuest(GuestDto guestDto);
    GuestDto guestToGuestDto(Guest guest);
}
