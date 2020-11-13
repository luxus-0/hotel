package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.service.RoomAvailableService;
import lukasz.nowogorski.exceptions.RoomIsFullException;
import lukasz.nowogorski.infrastructure.postgres.GuestRepository;
import lukasz.nowogorski.infrastructure.postgres.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomAvailableServiceImpl implements RoomAvailableService {

    private static final Logger log = LoggerFactory.getLogger(RoomAvailableServiceImpl.class);
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;


    public RoomAvailableServiceImpl(GuestRepository guestRepository, RoomRepository roomRepository) {
        this.guestRepository = guestRepository;

        this.roomRepository = roomRepository;
    }

    @Override
    public void getFreeRoom(Long beds) {
        roomRepository.findAll().stream()
                .filter(p -> getNumberGuest() < getNumberBed(beds))
                .forEach(System.out::println);
    }

    @Override
    public void getBusyRoom(Long beds) {

        if(getNumberGuest() >= getNumberBed(beds))
        {
            log.info("Room is full!!");
            throw new RoomIsFullException("Room is full!!");

        }
        else
        {
            log.info("Room is free");
            getFreeRoom(beds);
        }
    }

    Integer getNumberGuest()
    {
        return guestRepository.findAll().size();
    }

    Integer getNumberBed(Long beds)
    {
        return roomRepository.findByBeds(beds).size();
    }
}
