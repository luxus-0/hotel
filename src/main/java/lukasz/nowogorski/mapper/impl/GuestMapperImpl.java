package lukasz.nowogorski.mapper.impl;

import lukasz.nowogorski.model.Guest;
import lukasz.nowogorski.dto.GuestDto;
import lukasz.nowogorski.mapper.GuestMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestMapperImpl implements GuestMapper {
    @Override
    public Guest guestDtoToGuest(GuestDto guestDto) {
        return Guest.builder()
                .id(guestDto.getId())
                .name(guestDto.getName())
                .secondName(guestDto.getSecondName())
                .surname(guestDto.getSurname())
                .gender(guestDto.getGender())
                .email(guestDto.getEmail())
                .build();
    }

    @Override
    public GuestDto guestToGuestDto(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId())
                .name(guest.getName())
                .secondName(guest.getSecondName())
                .surname(guest.getSurname())
                .gender(guest.getGender())
                .email(guest.getEmail())
                .build();
    }
}
