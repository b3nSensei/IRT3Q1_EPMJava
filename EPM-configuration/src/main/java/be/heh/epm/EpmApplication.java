package be.heh.epm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Point d'entrée de l'application et scan les @ de l'application
public class EpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpmApplication.class, args);
	}

}
