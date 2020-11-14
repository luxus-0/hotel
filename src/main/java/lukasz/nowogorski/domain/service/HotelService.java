package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Hotel;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public interface HotelService {


    List<Hotel> findName(String name);
    List<Hotel> findNumberStars(Integer stars);
    List<Hotel> findEmail(String email);
    List<Hotel> findCheckIn(LocalTime checkIn);
    List<Hotel> findCheckOut(LocalTime checkOut);
    List<Hotel> findEarlyCheckIn(LocalTime earlyCheckIn);
    List<Hotel> findLateCheckIn(LocalTime lateCheckIn);
    List<Hotel> findLateCheckOut(LocalTime lateCheckOut);
    List<Hotel> findLateCheckoutFee(BigDecimal lateCheckOutFee);
}
