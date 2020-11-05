package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.jdbc.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InsertReservationQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapSqlParameterSource parameters = new MapSqlParameterSource();

    public ResponseEntity<HttpStatus> addReservation(Reservation reservation)
    {
        String sql = "INSERT INTO Reservation(id,createdDate,numberChildren,numberAdult,numberBed,password)" +
                     "VALUES(:id,createdDate,numberChildren,numberAdult,numberBed,password)";

        parameters.addValue("id",reservation.getId());
        parameters.addValue("createdDate",reservation.getCreatedDate());
        parameters.addValue("numberChildren",reservation.getNumberChildren());
        parameters.addValue("numberAdult",reservation.getNumberAdult());
        parameters.addValue("numberBed",reservation.getNumberBed());
        parameters.addValue("password",reservation.getPassword());

        jdbcTemplate.update(sql,parameters);

        return ResponseEntity.ok(HttpStatus.OK);

    }
}
