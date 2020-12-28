package lukasz.nowogorski.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongTimeStartFlighException extends RuntimeException {
    public WrongTimeStartFlighException(String s) {
    }
}
