package lukasz.nowogorski.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:h2.properties")
@PropertySource("classpath:error.properties")
@PropertySource("classpath:port.properties")
//@PropertySource("classpath:mysql.properties")
//@PropertySource("classpath:postgreSQL.properties")
public class DatabaseConfiguration {
}
