package my.sheshenya.samplespringdatajdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJdbcTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void persist_test(){

        Book book = new Book("Title1");

        Author author = new Author();
        author.setId(1L);
        author.setName("a1");
        book.addAuthor(author);

        Book save = repository.save(book); // save 1
        assertThat(save).isNotNull();

    }
}