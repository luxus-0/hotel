package lukasz.nowogorski.domain.service;

public interface AddressValidService {

    void valid();
    void valid(Long id);
    void validStreetNumber(Integer streetNumber);
    void validApartmentNumber(Integer apartmentNumber);
    void validPostalCode(String postalCode);
    void validCity(String city);
    void validCountry(String country);
}
