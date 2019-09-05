package ar.com.edu.unaj.nightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NightAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NightAppApplication.class, args);
	}

}
