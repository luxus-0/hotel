package lukasz.nowogorski.flight.repository;

import lukasz.nowogorski.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    public List<Flight> findFlightByFromCity(String fromCity);
    public List<Flight> findFlightByToCity(String toCity);
    public List<LocalDate> findFlightByDepartureDate(LocalDate departureDate);
    public List<LocalDate> findFlightByReturnDate(LocalDate returnDate);
    public List<LocalDate> findFlightByDepartureTime(LocalTime departureTime);
    public List<LocalDate> findFlightByReturnTime(LocalTime returnTime);
}
