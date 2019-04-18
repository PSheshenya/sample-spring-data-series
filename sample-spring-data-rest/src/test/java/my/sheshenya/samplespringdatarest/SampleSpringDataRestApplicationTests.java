package my.sheshenya.samplespringdatarest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringDataRestApplicationTests {

	@Autowired
	private FooRepository fooRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkPersist() {
		assertThat(fooRepository.findAll());
		//assertThat(fooRepository.findAll(), not(Matchers.emptyIterable()));
	}

}
