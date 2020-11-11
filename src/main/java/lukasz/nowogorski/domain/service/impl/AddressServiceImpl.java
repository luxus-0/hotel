package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Address;
import lukasz.nowogorski.domain.service.AddressService;
import lukasz.nowogorski.infrastructure.postgres.AddressRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Address> findAddress() {
        return repository.findAll();
    }

    @Override
    public Address findAddressById(Long id) {
        Optional<Address> addressOptional = repository.findById(id);
        return addressOptional.orElseThrow(() -> new EntityNotFoundException("No address with such id: " +id));
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
    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        Address addresses = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No address with such id: " +id));

        addresses.setId(address.getId());
        addresses.setStreet(address.getStreet());
        addresses.setStreetNumber(address.getStreetNumber());
        addresses.setApartmentNumber(address.getApartmentNumber());
        addresses.setPostalCode(address.getPostalCode());
        addresses.setCity(address.getCity());
        addresses.setCountry(address.getCountry());
        return repository.save(addresses);
    }

    public void deleteAddressById(Long id)
    {
        repository.deleteById(id);
    }

    public void deleteAddress()
    {
        repository.deleteAll();
    }


}
