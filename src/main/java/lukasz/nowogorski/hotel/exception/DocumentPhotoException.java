package lukasz.nowogorski.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentPhotoException extends RuntimeException {
    public DocumentPhotoException(String s, IOException e) {
    }

    public DocumentPhotoException(String s) {
    }
}
