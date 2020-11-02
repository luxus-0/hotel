package hotel_app.hotel.jdbc.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotel_app.hotel.jdbc.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class SelectRoomQuery {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String get() throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room", new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }

    public String getId(Long id) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE id = :id"
                ,new MapSqlParameterSource()
                        .addValue("id",id), new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }


    public String getBeds(Integer beds) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE beds = :beds"
                ,new MapSqlParameterSource()
                        .addValue("beds",beds),new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }



    public String getPersonNumber(Integer personNumber) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE personNumber = :personNumber"
                ,new MapSqlParameterSource()
                        .addValue("personNumber",personNumber),new BeanPropertyRowMapper<>(Room.class));
            return objectMapper.writeValueAsString(rooms);
    }

    public String getPriceForNight(Double priceForNight) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE priceForNight = :priceForNight"
                ,new MapSqlParameterSource()
                        .addValue("priceForNight",priceForNight),new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }


    public String getPrice(Double price) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE price = :price"
                ,new MapSqlParameterSource()
                        .addValue("price",price),new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }

    public String getAvailable(Boolean available) throws JsonProcessingException {
        List rooms = jdbcTemplate.query("SELECT * FROM room WHERE available = :available"
                ,new MapSqlParameterSource().addValue("available",available),new BeanPropertyRowMapper<>(Room.class));
        return objectMapper.writeValueAsString(rooms);
    }



}
