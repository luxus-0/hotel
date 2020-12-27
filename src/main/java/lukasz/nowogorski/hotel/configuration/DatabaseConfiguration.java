package lukasz.nowogorski.hotel.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:hotel_h2.properties")
@PropertySource("classpath:flight_h2.properties")
@PropertySource("port.properties")
//@PropertySource("classpath:mysql.properties")
//@PropertySource("classpath:postgreSQL.properties")
public class DatabaseConfiguration {
}
