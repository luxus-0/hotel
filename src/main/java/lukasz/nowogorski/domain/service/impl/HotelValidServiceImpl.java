package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Hotel;
import lukasz.nowogorski.domain.service.HotelValidService;
import lukasz.nowogorski.exception.HotelNameNotFound;
import lukasz.nowogorski.exception.HotelNotFound;
import lukasz.nowogorski.infrastructure.postgres.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class HotelValidServiceImpl implements HotelValidService {

    private static final Logger log = LoggerFactory.getLogger(HotelValidServiceImpl.class);
    private final HotelRepository repository;

    public HotelValidServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void valid() {
        List<Hotel> getHotel = repository.findAll();

        if(getHotel.isEmpty())
        {
            throw new HotelNotFound("Hotel not found!!");
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getId() > 0)
                    .forEach(System.out::println);
            log.info("Hotel is found" + getHotel);
        }
    }

    @Override
    public void valid(Long id) {
        Optional<Hotel> optionalHotel = repository.findById(id);

        if(optionalHotel.isEmpty())
        {
            throw new HotelNotFound("Hotel not found with id: "+id);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getId() > 0)
                    .forEach(System.out::println);
            log.info("Hotel is found with id: " + id);
        }
    }

    @Override
    public void validName(String name) {
        List<Hotel> names = repository.findByName(name);

        if(names.isEmpty())
        {
            throw new HotelNameNotFound("Hotel name not found!!");
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getName().equals(""))
                    .forEach(System.out::println);
            log.info("Hotel name found: " +names);
        }
    }

    @Override
    public void validNumberStars(Integer stars) {

    }

    @Override
    public void validEmail(String email) {

    }

    @Override
    public void validCheckIn(LocalTime checkIn) {

    }

    @Override
    public void validCheckOut(LocalTime checkOut) {

    }

    @Override
    public void validEarlyCheckIn(LocalTime earlyCheckIn) {

    }

    @Override
    public void validLateCheckIn(LocalTime lateCheckIn) {

    }

    @Override
    public void validLateCheckOut(LocalTime lateCheckOut) {

    }

    @Override
    public void validLateCheckoutFee(BigDecimal lateCheckOutFee) {

    }
}
