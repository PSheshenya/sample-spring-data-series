package my.sheshenya.samplespringdatajdbc;

import javafx.collections.ModifiableObservableListBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class SampleSpringDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringDataJdbcApplication.class, args);
	}


	@Bean
	AuditorAware<String> auditorAware(){
		return new ModifiableAuditorAware();
	}
}
