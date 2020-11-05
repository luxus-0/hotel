package hotel_app.hotel.jdbc.query;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Log4j2
public class CreateReservationQuery {

    private final JdbcTemplate jdbcTemplate;

    public void createReservation()
    {
        String sql = "CREATE TABLE Room(id Long NOT NULL," +
                "    LocalDate CreatedDate NOT NULL," +
                "    Integer numberChildren NOT NULL," +
                "    Integer numberAdult NOT NULL," +
                "    Integer numberBed NOT NULL," +
                "    String password NOT NULL)";

        jdbcTemplate.execute(sql);
        log.info("CREATE TABLE ROOM");
    }
}
