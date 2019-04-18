package my.sheshenya.samplespringdatajdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJdbcTest
public class FooRepositoryTest {

    @Autowired
    private FooRepository repository;

    @Test
    public void persist_test(){

        Foo foo = Foo.builder().name("First").email("f@ggg.com").build();

        Foo save = repository.save(foo); // save 1
        assertThat(save).isNotNull();

        save.setId(null);//jdbc assume as new entity
        Foo newSave = repository.save(save); // save 2
        assertThat(repository.count()).isEqualTo(2);

        Optional<Foo> saveOne = repository.findById(save.getId());
        Optional<Foo> saveOneAgain = repository.findById(save.getId());
        assertThat(saveOne).isNotSameAs(saveOneAgain);
    }

}