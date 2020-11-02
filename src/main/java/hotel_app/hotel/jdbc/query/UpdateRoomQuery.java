package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class UpdateRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void updateRoom(Room room,Long id)
    {
        String sql = "UPDATE ROOM SET id = :id, beds = :beds, price = :price, available = :available" +
                ",personNumber = :personNumber,roomType = :roomType, priceForNight = :priceForNight" +
                "WHERE id = :id)";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id",room.getId())
                .addValue("beds",room.getBeds())
                .addValue("price",room.getPrice())
                .addValue("available",room.getAvailable())
                .addValue("personNumber",room.getPersonNumber())
                .addValue("roomType",room.getRoomType())
                .addValue("priceForNight",room.getPriceForNight());

        int status = jdbcTemplate.update(sql,parameters);
        if(status != 0)
        {
            Logger log = LoggerFactory.getLogger(UpdateRoomQuery.class);
            log.info("ROOM UPDATE FOR ID: " +id);
        }
    }
}
