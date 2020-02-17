package api.series.tv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"api.series.tv"})
@ComponentScan(basePackages = {"api.*"})  
@RestController
@EnableAutoConfiguration
public class ApiSeriesTvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSeriesTvApplication.class, args);
	}

}
