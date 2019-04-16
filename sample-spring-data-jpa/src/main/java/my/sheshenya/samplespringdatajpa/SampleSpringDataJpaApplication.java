package my.sheshenya.samplespringdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SampleSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringDataJpaApplication.class, args);
	}

}
