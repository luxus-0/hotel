package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.entity.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateReservationQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapSqlParameterSource parameters = new MapSqlParameterSource();

    public void updateReservation(Reservation reservation)
    {
        String sql = "UPDATE Reservation SET id = :id, createdDate = :createdDate," +
                " numberChildren = :numberChildren, numberAdult = :numberAdult," +
                " numberBed = :numberBed, password =:password ";

        parameters.addValue("id",reservation.getId());
        parameters.addValue("createdDate",reservation.getCreatedDate());
        parameters.addValue("numberChildren",reservation.getNumberChildren());
        parameters.addValue("numberAdult",reservation.getNumberAdult());
        parameters.addValue("numberBed",reservation.getNumberBed());
        parameters.addValue("password",reservation.getPassword());

        jdbcTemplate.update(sql,parameters);

    }
}
