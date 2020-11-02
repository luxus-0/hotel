package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class InsertRoomQuery {

   private final NamedParameterJdbcTemplate jdbcTemplate;

public ResponseEntity<HttpStatus> addRoom(Room room)
{
    String sql = "INSERT INTO ROOM(id,beds,price,available,personNumber,roomType,priceForNight)" +
                 "VALUES(:id, :beds, :price, :available, :personNumber, :roomType, :priceForNight)     ";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id",room.getId())
                .addValue("beds",room.getBeds())
                .addValue("price",room.getPrice())
                .addValue("available",room.getAvailable())
                .addValue("personNumber",room.getPersonNumber())
                .addValue("roomType",room.getRoomType())
                .addValue("priceForNight",room.getPriceForNight());

        jdbcTemplate.update(sql,parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
