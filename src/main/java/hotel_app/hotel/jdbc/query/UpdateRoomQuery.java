package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void updateRoom(Room room,Long id)
    {
        String sql = "UPDATE ROOM SET id = :id, beds = :beds, price = :price, available = :available" +
                ",personNumber = :personNumber,roomType = :roomType, priceForNight = :priceForNight";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id",room.getId())
                .addValue("beds",room.getBeds())
                .addValue("price",room.getPrice())
                .addValue("available",room.getAvailable())
                .addValue("personNumber",room.getPersonNumber())
                .addValue("roomType",room.getRoomType())
                .addValue("priceForNight",room.getPriceForNight());

       jdbcTemplate.update(sql,parameters);
    }
}
