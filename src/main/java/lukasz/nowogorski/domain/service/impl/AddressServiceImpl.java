package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressService;
import lukasz.nowogorski.infrastructure.postgres.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
    }

    @Override
    public Optional<Address> findAddressById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Address> findAddressByStreetNumber(String streetNumber) {
        return repository.findByStreetNumber(streetNumber);
    }

    @Override
    public List<Address> findAddressByApartmentNumber(String apartmentNumber) {
        return repository.findByApartmentNumber(apartmentNumber);
    }

    @Override
    public List<Address> findAddressByPostalCode(String postalCode) {
        return repository.findByPostalCode(postalCode);
    }

    @Override
    public List<Address> findAddressByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Address> findAddressByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public Address add(Address address) {
        return repository.add(address);
    }

    @Override
    public Address update(Address address, Long id) {
        return repository.update(address,id);
    }
}
