package lukasz.nowogorski.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdultNumberNotFound extends RuntimeException {
    public AdultNumberNotFound(String message) {
    }
}
