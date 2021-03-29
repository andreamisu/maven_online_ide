package edu.tum.ase.darkmode;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DarkmodeApplication {

	public boolean darkMode = false;
	public Date lastUpdate = new Date();
	public static void main(String[] args) {
	SpringApplication.run(DarkmodeApplication.class, args);
	}

	@RequestMapping(path = "/dark-mode/toggle", method = RequestMethod.GET)
	public void toggleDarkMode() {
		Date scopedTime = new Date();
		if((scopedTime.getTime() - lastUpdate.getTime()) > 3 * 1000){
			darkMode = !darkMode;
			lastUpdate = scopedTime;
		}
	}

	@RequestMapping(path = "/dark-mode", method = RequestMethod.GET)
	public boolean darkMode() {
		return darkMode;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedOrigins("*");
			}
		};
	}
}
