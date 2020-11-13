package lukasz.nowogorski.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomIsFullException extends RuntimeException {
    public RoomIsFullException(String message) {
    }
}
