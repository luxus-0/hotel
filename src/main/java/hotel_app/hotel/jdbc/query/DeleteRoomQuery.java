package hotel_app.hotel.jdbc.query;

import hotel_app.hotel.entity.RoomType;
import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class DeleteRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void deleteRoom(Room room,Long id) {
        String sql = "DELETE FROM ROOM WHERE beds = :beds, price = :price, available = :available" +
                ",personNumber = :personNumber,roomType = :roomType, priceForNight = :priceForNight" +
                "WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id",room.getId())
                .addValue("beds",room.getBeds())
                .addValue("price",room.getPrice())
                .addValue("available",room.getAvailable())
                .addValue("personNumber",room.getPersonNumber())
                .addValue("roomType",room.getRoomType())
                .addValue("priceForNight",room.getPriceForNight());

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomById(Long id) {
            String sql = "DELETE FROM ROOM WHERE id = :id";
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("id",id);

            jdbcTemplate.update(sql, parameters);
        }

    public void deleteRoombyBeds(Integer beds) {
        String sql = "DELETE FROM ROOM WHERE beds = :beds";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("beds",beds);

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomByPrice(Double price) {
        String sql = "DELETE FROM ROOM WHERE price = :price";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("price",price);

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomByPriceForNight(Double priceForNight)
    {
        String sql = "DELETE FROM ROOM WHERE priceForNight = :priceForNight";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("priceForNight",priceForNight);

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomByAvailable(Boolean available) {
        String sql = "DELETE FROM ROOM WHERE available = :available";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("available",available);

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomByPersonNumber(Integer personNumber) {
        String sql = "DELETE FROM ROOM WHERE personNumber = :personNumber";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("personNumber",personNumber);

        jdbcTemplate.update(sql, parameters);
    }

    public void deleteRoomByRoomType(RoomType roomType) {
        String sql = "DELETE FROM ROOM WHERE roomType = :roomType";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("roomType",roomType);

        jdbcTemplate.update(sql, parameters);
    }


}
