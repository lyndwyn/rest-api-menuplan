package ch.ilge.ivy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// TODO comment
@ComponentScan
@SpringBootApplication
public class IvyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IvyApplication.class, args);
	}

}
