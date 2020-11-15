package lukasz.nowogorski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StreetNumberNotFound extends RuntimeException {
    public StreetNumberNotFound(String s) {
    }
}
