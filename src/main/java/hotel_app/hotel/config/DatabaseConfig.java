package hotel_app.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:postgreSQL.properties")
@PropertySource("classpath:h2.properties")
public class DatabaseConfig {

}
