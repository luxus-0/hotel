package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.service.RoomTotalCostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoomTotalCostServiceImpl implements RoomTotalCostService {


    @Override
    public Float getTotalCost(Integer numberDays,Float priceForNight) {
        Integer checkIn = LocalDateTime.now().getDayOfMonth();
        Integer checkOut = LocalDateTime.now().plusDays(numberDays).getDayOfMonth();
        return priceForNight * (checkOut-checkIn);
    }

}
