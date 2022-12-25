package project.streetfoodreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class StreetfoodreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreetfoodreviewApplication.class, args);
	}

}
