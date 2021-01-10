package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class SeatCreator {

    public Seat createSeat(Seat seat)
    {
        return Seat.builder()
                .id(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .ifFree(seat.getIfFree())
                .build();
    }
}
