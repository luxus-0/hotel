package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Hotel;
import lukasz.nowogorski.domain.service.HotelService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Override
    public List<Hotel> findCheckIn(LocalDateTime checkIn) {
        return null;
    }

    @Override
    public List<Hotel> findCheckOut(LocalDateTime checkOut) {
        return null;
    }
}
