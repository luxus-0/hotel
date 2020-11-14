package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Hotel;
import lukasz.nowogorski.domain.service.HotelService;
import lukasz.nowogorski.infrastructure.postgres.HotelRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public List<Hotel> findNumberStars(Integer stars) {
        return hotelRepository.findByNumberStars(stars);
    }

    @Override
    public List<Hotel> findEmail(String email) {
        return hotelRepository.findByEmail(email);
    }

    @Override
    public List<Hotel> findCheckIn(LocalTime checkIn) {
        return hotelRepository.findByCheckIn(checkIn);
    }

    @Override
    public List<Hotel> findCheckOut(LocalTime checkOut) {
        return hotelRepository.findByCheckOut(checkOut);
    }

    @Override
    public List<Hotel> findEarlyCheckIn(LocalTime earlyCheckIn) {
        return hotelRepository.findByEarlyCheckIn(earlyCheckIn);
    }

    @Override
    public List<Hotel> findLateCheckIn(LocalTime lateCheckIn) {
        return hotelRepository.findByLateCheckIn(lateCheckIn);
    }

    @Override
    public List<Hotel> findLateCheckOut(LocalTime lateCheckOut) {
        return hotelRepository.findByLateCheckOut(lateCheckOut);
    }

    @Override
    public List<Hotel> findLateCheckoutFee(BigDecimal lateCheckOutFee) {
        return hotelRepository.findByLateCheckoutFee(lateCheckOutFee);
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel() {
        hotelRepository.deleteAll();
    }


}
