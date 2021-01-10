package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lukasz.nowogorski.flight.model.Address;
import lukasz.nowogorski.flight.model.Passenger;
import lukasz.nowogorski.flight.model.Pilot;
import lukasz.nowogorski.flight.model.Seat;
import lukasz.nowogorski.hotel.model.AddressHotel;
import lukasz.nowogorski.hotel.model.Gender;
import org.springframework.stereotype.Service;
import javax.persistence.*;

@Service
@RequiredArgsConstructor
public class PassengerCreator {

private final SeatCreator seat;
private final AddressCreator address;
private final PilotCreator pilot;

    public Passenger createPassenger(Passenger passenger, Address addr,Pilot pil)
    {
        return Passenger.builder()
                .idPassenger(passenger.getIdPassenger())
                .name(passenger.getName())
                .surname(passenger.getSurname())
                .mobile(passenger.getMobile())
                .gender(passenger.getGender())
                .pesel(passenger.getPesel())
                .email(passenger.getEmail())
                .seat(seat.createSeat(passenger.getSeat()))
                .addressPassenger(address.addressCreator(addr))
                .pilot()
                .build();

    }
}
