package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapSqlParameterSource parameters = new MapSqlParameterSource();

    public ResponseEntity<HttpStatus> deleteRoom(Room room) {
        String sql = "DELETE FROM ROOM WHERE id = :id, beds = :beds, price = :price, available = :available" +
                ",personNumber = :personNumber,roomType = :roomType, priceForNight = :priceForNight";

                parameters.addValue("id",room.getId());
                parameters.addValue("beds",room.getBeds());
                parameters.addValue("price",room.getPrice());
                parameters.addValue("available",room.getAvailable());
                parameters.addValue("personNumber",room.getPersonNumber());
                parameters.addValue("roomType",room.getRoomType());
                parameters.addValue("priceForNight",room.getPriceForNight());

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomById(Long id) {
            String sql = "DELETE FROM ROOM WHERE id = :id";
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("id",id);

            jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
        }

    public ResponseEntity<HttpStatus> deleteRoombyBeds(Integer beds) {
        String sql = "DELETE FROM ROOM WHERE beds = :beds";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("beds",beds);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomByPrice(Double price) {
        String sql = "DELETE FROM ROOM WHERE price = :price";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("price",price);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomByPriceForNight(Double priceForNight)
    {
        String sql = "DELETE FROM ROOM WHERE priceForNight = :priceForNight";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("priceForNight",priceForNight);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomByAvailable(Boolean available) {
        String sql = "DELETE FROM ROOM WHERE available = :available";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("available",available);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomByPersonNumber(Integer personNumber) {
        String sql = "DELETE FROM ROOM WHERE personNumber = :personNumber";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("personNumber",personNumber);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteRoomByRoomType(RoomType roomType) {
        String sql = "DELETE FROM ROOM WHERE roomType = :roomType";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("roomType",roomType);

        jdbcTemplate.update(sql, parameters);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
