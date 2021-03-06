package com.buzzardsview.needalight;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class NeedALightApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedALightApplication.class, args);
	}

}
