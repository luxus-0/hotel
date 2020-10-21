package hotel_app.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PaymentIsEmptyException extends RuntimeException {

    public PaymentIsEmptyException(String message) {
        super(message);
    }
}
