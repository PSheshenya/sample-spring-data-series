package my.sheshenya.samplespringdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringDataJpaApplicationTests {

	@Autowired
	private FooRepository fooRepository;


	@Transactional
	@Test
	@Sql(scripts = { "/test-foo-data.sql" })
	public void deleteByName() {

		Long deletedCount = fooRepository.deleteByName("First");

		assertEquals("deleted foo count is not matching", 1, deletedCount.intValue());
	}


	@Transactional
	@Test
	@Sql(scripts = { "/test-foo-data.sql" })
	public void deleteByEmail() {

		List<Foo> fooList = fooRepository.deleteByEmail("s@ggg.com");

		assertEquals("number of foos", 1, fooList.size());
		fooList.forEach(foo -> assertEquals("Its not with s@ggg.com", "s@ggg.com", foo.getEmail()));
	}




	@Transactional
	@Test
	@Sql(scripts = { "/test-foo-data.sql" })
	public void deleteByNameOrEmail1() {
		//List<Foo> fooList = fooRepository.deleteByNameOrEmail ("First", "s@ggg.com");
		fooRepository.deleteByNameOrEmail ("First", "s@ggg.com");
		List<Foo> fooOtherList = fooRepository.findAll();

		assertEquals("number of foos are not matching 'First' or 's@ggg.com'", 1, fooOtherList.size());
		fooOtherList.forEach(fruit -> assertTrue("Its not a First or with s@ggg.com", !("First".equals(fruit.getName()) && "s@ggg.com".equals(fruit.getEmail()))));
	}


	@Transactional
	@Test
	@Sql(scripts = { "/test-foo-data.sql" })
	public void deleteByNameOrEmail2() {

		Foo dFoo = new Foo();
		dFoo.setName("First");
		dFoo.setEmail("s@ggg.com");
		fooRepository.deleteByNameOrEmail (dFoo);
		List<Foo> fooOtherList = fooRepository.findAll();

		assertEquals("number of foos are not matching 'First' or 's@ggg.com'", 1, fooOtherList.size());
		fooOtherList.forEach(fruit -> assertTrue("Its not a First or with s@ggg.com", !("First".equals(fruit.getName()) && "s@ggg.com".equals(fruit.getEmail()))));
	}
}
