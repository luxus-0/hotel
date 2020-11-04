package hotel_app.hotel.jdbc.query;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Log4j2
public class CreateRoomQuery {

private final JdbcTemplate jdbcTemplate;

public void createRoom()
    {

        String sql = "CREATE TABLE Room(id Long NOT NULL," +
            "    Integer beds NOT NULL," +
            "    Double price NOT NULL," +
            "    Boolean available NOT NULL," +
            "    Integer personNumber NOT NULL," +
            "    RoomType roomType NOT NULL," +
            "    Double priceForNight NOT NULL)";
        jdbcTemplate.execute(sql);
        log.info("CREATE TABLE ROOM");
    }
}
