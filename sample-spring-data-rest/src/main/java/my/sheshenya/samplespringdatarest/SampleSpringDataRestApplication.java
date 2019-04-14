package my.sheshenya.samplespringdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SampleSpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringDataRestApplication.class, args);
	}


	@Autowired
	private FooRepository fooRepository;

	@Component
	class DataSetup implements ApplicationRunner{

		@Override
		public void run(ApplicationArguments args) throws Exception {
			fooRepository.save(Foo.builder().name("First").email("f@ggg.com").build());
			fooRepository.save(Foo.builder().name("Second").email("s@ggg.com").build());
			fooRepository.save(Foo.builder().name("Thirdth").email("t@ggg.com").build());
		}
	}
}
