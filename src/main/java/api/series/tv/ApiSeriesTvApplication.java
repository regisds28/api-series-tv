package api.series.tv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"api.series.tv"})
@ComponentScan(basePackages = {"api.*"})  
@RestController
@EnableAutoConfiguration
public class ApiSeriesTvApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ApiSeriesTvApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("*");
	}
	
}
