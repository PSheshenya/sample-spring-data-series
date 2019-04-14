package my.sheshenya.samplespringdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "foos", path = "foos")
public interface FooRepository extends PagingAndSortingRepository<Foo, Long> {
    List<Foo> findByName(@Param("name") String name);
}