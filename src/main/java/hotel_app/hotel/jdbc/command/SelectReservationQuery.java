package hotel_app.hotel.jdbc.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotel_app.hotel.jdbc.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SelectReservationQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public String get() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }

    public String getId() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation WHERE id = :id"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }

    public String getCreatedDate() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation WHERE createdDate = :createdDate"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }



    public String getNumberChildren() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation WHERE numberChildren = :numberChildren"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }

    public String getNumberAdult() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation WHERE numberAdult = :numberAdult"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }

    public String getNumberBed() throws JsonProcessingException {
        List reservations = jdbcTemplate.query("SELECT * From Reservation WHERE numberBed = :numberBed"
                ,new BeanPropertyRowMapper<>(Reservation.class));
        return objectMapper.writeValueAsString(objectMapper);
    }
}
