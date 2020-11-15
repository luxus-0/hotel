package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressValidService;
import lukasz.nowogorski.exception.*;
import lukasz.nowogorski.infrastructure.postgres.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressValidServiceImpl implements AddressValidService {

    private final AddressRepository repository;
    private static final Logger log = LoggerFactory.getLogger(AddressValidServiceImpl.class);

    AddressValidServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public void valid() {
        List<Address> getAddress = repository.findAll();

        if(getAddress.isEmpty())
        {
            throw new AddressNotFound("Address not found!!");
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getId() > 0)
                    .forEach(System.out::println);
            log.info("Address is found" + getAddress);
        }
    }

    @Override
    public void valid(Long id) {
        Optional<Address> optionalAddress = repository.findById(id);

        if(optionalAddress.isEmpty())
        {
            throw new AddressNotFound("Address not found by id: "+id);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getId() > 0)
                    .forEach(System.out::println);
            log.info("Address is found with id: " + id);
        }
    }

    @Override
    public void validStreetNumber(Integer streetNumber) {
        if(repository.findByStreetNumber(streetNumber) == null)
        {
            throw new StreetNumberNotFound("Street number not found: " +streetNumber);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getStreetNumber() > 0)
                    .forEach(System.out::println);
            log.info("Street number is: " +streetNumber);
        }
    }

    @Override
    public void validApartmentNumber(Integer apartmentNumber) {
        if(repository.findByApartmentNumber(apartmentNumber) == null)
        {
            throw new ApartmentNumberNotFound("Apartment number not found: " +apartmentNumber);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getApartmentNumber() > 0)
                    .forEach(System.out::println);
            log.info("Apartment number is: " +apartmentNumber);
        }
    }

    @Override
    public void validPostalCode(String postalCode) {
        if(repository.findByPostalCode(postalCode) == null)
        {
            throw new PostalCodeNotFound("Postal code not found: " +postalCode);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getPostalCode().equals(""))
                    .forEach(System.out::println);
            log.info("Postal code is: " +postalCode);
        }
    }

    @Override
    public void validCity(String city) {
        if(repository.findByCity(city) == null)
        {
            throw new CityNotFound("City not found: " +city);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getCity().equals(""))
                    .forEach(System.out::println);
            log.info("City is: " +city);
        }
    }

    @Override
    public void validCountry(String country) {
        if(repository.findByCountry(country) == null)
        {
            throw new CountryNotFound("Country not found: " +country);
        }
        else
        {
            repository.findAll().stream()
                    .filter(p -> p.getCountry().equals(""))
                    .forEach(System.out::println);
            log.info("Country is: " +country);
        }
    }
}
