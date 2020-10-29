package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.ReservationDTO;
import hotel_app.hotel.entity.Reservation;
import org.modelmapper.ModelMapper;

public class ReservationMapperImpl implements ReservationMapper {



    @Override
    public Reservation toBooking(ReservationDTO reservationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        reservation.setCreatedDate(reservationDTO.getCreatedDate());
        reservation.setNumberChildren(reservationDTO.getNumberChildren());
        reservation.setNumberAdult(reservationDTO.getNumberAdult());
        reservation.setNumberBed(reservationDTO.getNumberBed());


        return reservation;
    }

    @Override
    public ReservationDTO toBookingDTO(Reservation reservation) {
        ModelMapper modelMapper = new ModelMapper();
        ReservationDTO reservationDTO = modelMapper.map(reservation,ReservationDTO.class);
        reservationDTO.setCreatedDate(reservation.getCreatedDate());
        reservationDTO.setNumberChildren(reservation.getNumberChildren());
        reservationDTO.setNumberAdult(reservation.getNumberAdult());
        reservationDTO.setNumberBed(reservation.getNumberBed());

        return reservationDTO;
    }
    
}
