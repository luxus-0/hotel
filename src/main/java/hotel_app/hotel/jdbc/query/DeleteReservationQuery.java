package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.entity.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class DeleteReservationQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapSqlParameterSource parameters = new MapSqlParameterSource();

    public ResponseEntity<HttpStatus> deleteReservation(Reservation reservation)
    {

        String sql = "DELETE FROM Reservation WHERE id = :id, createdDate = :createdDate," +
                " numberChildren = :numberChildren, numberAdult = :numberAdult ," +
                "numberBed = :numberBed,password = :password";

        parameters.addValue("id",reservation.getId());
        parameters.addValue("createdDate",reservation.getCreatedDate());
        parameters.addValue("numberChildren",reservation.getNumberChildren());
        parameters.addValue("numberAdult",reservation.getNumberAdult());
        parameters.addValue("numberBed",reservation.getNumberBed());
        parameters.addValue("password",reservation.getPassword());

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteReservationById(Long id)
    {
        String sql = "DELETE FROM Reservation WHERE id = :id";
        parameters.addValue("id",id);

        jdbcTemplate.update(sql,parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteReservationByCreatedDate(LocalDate createdDate)
    {
        String sql = "DELETE FROM Reservation WHERE createdDate = :createdDate";
        parameters.addValue("createdDate",createdDate);

        jdbcTemplate.update(sql,parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteReservationByNumberChildren(Integer numberChildren)
    {
        String sql = "DELETE FROM Reservation WHERE numberChildren = :numberChildren";
        parameters.addValue("numberChildren",numberChildren);

        jdbcTemplate.update(sql,parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteReservationByNumberAdult(Integer numberAdult)
    {
        String sql = "DELETE FROM Reservation WHERE numberAdult = :numberAdult";
        parameters.addValue("numberAdult",numberAdult);

        jdbcTemplate.update(sql,parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteReservationByNumberBed(Integer numberBed)
    {
        String sql = "DELETE FROM Reservation WHERE numberBed = :numberBed";
        parameters.addValue("numberBed",numberBed);

        jdbcTemplate.update(sql,parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
