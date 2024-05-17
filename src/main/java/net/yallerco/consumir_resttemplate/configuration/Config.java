package net.yallerco.consumir_resttemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}


}
