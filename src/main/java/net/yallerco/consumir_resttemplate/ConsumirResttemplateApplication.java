package net.yallerco.consumir_resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumirResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumirResttemplateApplication.class, args);
	}

}
