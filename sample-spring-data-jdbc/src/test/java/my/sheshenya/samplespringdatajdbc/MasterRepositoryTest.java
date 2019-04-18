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
public class MasterRepositoryTest {

    @Autowired
    private MasterRepository repository;

    @Test
    public void persistWithRels_test(){

        Master master = Master.builder().name("Zero").build();
        Master save = repository.save(master); // save 1
        assertThat(save).isNotNull();




        Master master1 = Master.builder().name("First").details(new HashMap<>()).build();
        Detail detail1 = new Detail();
        detail1.setName("detail1 name");
        master1.getDetails().put("detail1", detail1);

        Master save1 = repository.save(master1); // save 2
        assertThat(save1).isNotNull();

        repository.delete(save);
        assertThat(save).isNotNull();

    }
}