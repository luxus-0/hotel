package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MapSqlParameterSource parameters = new MapSqlParameterSource();

    public void updateRoom(Room room)
    {
        String sql = "UPDATE Room SET id = :id, beds = :beds, price = :price, available = :available" +
                ",personNumber = :personNumber,roomType = :roomType, priceForNight = :priceForNight";

                parameters.addValue("id",room.getId());
                parameters.addValue("beds",room.getBeds());
                parameters.addValue("price",room.getPrice());
                parameters.addValue("available",room.getAvailable());
                parameters.addValue("personNumber",room.getPersonNumber());
                parameters.addValue("roomType",room.getRoomType());
                parameters.addValue("priceForNight",room.getPriceForNight());

       jdbcTemplate.update(sql,parameters);
    }
}
