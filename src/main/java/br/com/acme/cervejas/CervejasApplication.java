package br.com.acme.cervejas;

import info.schnatterer.mobynamesgenerator.MobyNamesGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

@SpringBootApplication
public class CervejasApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();
		String randomName = MobyNamesGenerator.getRandomName();
		properties.put("application.name", randomName);
		new SpringApplicationBuilder(CervejasApplication.class).properties(properties).run(args);
	}

}
