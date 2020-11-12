package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddress();
    Address findAddressById(Long id);
    List<Address> findAddressByStreetNumber(Integer streetNumber);
    List<Address> findAddressByApartmentNumber(Integer apartmentNumber);
    List<Address> findAddressByPostalCode(String postalCode);
    List<Address> findAddressByCity(String city);
    List<Address> findAddressByCountry(String country);
    Address saveAddress(Address address);
    Address updateAddress(Address address, Long id);
    void deleteAddress();
    void deleteAddressById(Long id);


}
