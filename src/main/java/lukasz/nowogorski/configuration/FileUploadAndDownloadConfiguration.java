package lukasz.nowogorski.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:Hotel_Picture.properties")
@Configuration
public class FileUploadAndDownloadConfiguration {
}
