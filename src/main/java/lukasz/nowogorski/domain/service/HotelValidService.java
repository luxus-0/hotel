package lukasz.nowogorski.domain.service;

import java.math.BigDecimal;
import java.time.LocalTime;

public interface HotelValidService {


    void validName(String name);
    void validNumberStars(Integer stars);
    void validEmail(String email);
    void validCheckIn(LocalTime checkIn);
    void validCheckOut(LocalTime checkOut);
    void validEarlyCheckIn(LocalTime earlyCheckIn);
    void validLateCheckIn(LocalTime lateCheckIn);
    void validLateCheckOut(LocalTime lateCheckOut);
    void validLateCheckoutFee(BigDecimal lateCheckOutFee);
}
