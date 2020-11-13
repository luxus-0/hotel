package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Reservation;
import lukasz.nowogorski.exceptions.ExtraBedNotFound;

public interface ReservationValidService {

    void valid(Reservation reservation);
    void valid(Long id);
    void validChildrenNumber(Integer childrenNumber);
    void validAdultNumber(Integer adultNumber);
    void validExtraBedNumber(Integer extraBedNumber) throws ExtraBedNotFound;
    void validPayment(String payment);
}
