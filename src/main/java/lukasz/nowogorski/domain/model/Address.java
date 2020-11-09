package lukasz.nowogorski.domain.model;

public class Address {

    private final String street;
    private final String streetNumber;
    private final String apartmentNumber;
    private final String postalCode;
    private final String city;
    private final String country;

    public Address(String street, String streetNumber, String apartmentNumber, String postalCode, String city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
