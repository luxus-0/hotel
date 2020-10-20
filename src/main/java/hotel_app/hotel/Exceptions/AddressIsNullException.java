package hotel_app.hotel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressIsNullException extends RuntimeException {
    public AddressIsNullException(String message) {
        super(message);
    }
}
