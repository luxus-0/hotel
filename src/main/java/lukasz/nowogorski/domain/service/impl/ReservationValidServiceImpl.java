package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Reservation;
import lukasz.nowogorski.domain.service.ReservationValidService;
import lukasz.nowogorski.exceptions.*;
import lukasz.nowogorski.infrastructure.postgres.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReservationValidServiceImpl implements ReservationValidService {

    private final ReservationRepository repository;
    private final static Logger log = LoggerFactory.getLogger(ReservationValidServiceImpl.class);

    ReservationValidServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void valid(Reservation reservation) {


        if(reservation.getId() < 0)
        {
            throw new ReservationNotFound("Reservation not found!!");
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getId() > 0)
                    .forEach(System.out::println);
            log.info("Reservation is found");
        }
    }

    @Override
    public void valid(Long id) {

        repository.findById(id)
                .orElseThrow(()-> new IdNotFound("Id not found!!" +id));
    }

    @Override
    public void validChildrenNumber(Integer childrenNumber) {
        if(repository.findByChildrenNumber(childrenNumber) == null)
        {
            throw new ChildrenNumberNotFound("Children number not found: " +childrenNumber);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getExtraBedNumber() > 0)
                    .forEach(System.out::println);
            log.info("Children number is: " +childrenNumber);
        }
    }

    @Override
    public void validAdultNumber(Integer adultNumber) {
        if(repository.findByAdultNumber(adultNumber) == null)
        {
            throw new AdultNumberNotFound("Adult number not found: " +adultNumber);
        }
        else
        {
            repository.findAll()
                    .stream().filter(p -> p.getAdultNumber() > 0)
                    .forEach(System.out::println);
            log.info("Adult number is: " +adultNumber);
        }
    }

    @Override
    public void validExtraBedNumber(Integer extraBedNumber) {
        if(repository.findByExtraBedNumber(extraBedNumber) == null)
        {
            throw new ExtraBedNotFound("Extra bed number not found: " +extraBedNumber);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getExtraBedNumber() > 0)
                    .forEach(System.out::println);
            log.info("Extra bed number is: " +extraBedNumber);
        }
    }

    @Override
    public void validPayment(String payment) {
        if(repository.findByPayment(payment) == null)
        {
            throw new PaymentNotFound("Payment not found: " +payment);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getPayment().equals(""))
                    .forEach(System.out::println);
            log.info("Payment is: " +payment);
        }
    }



}
