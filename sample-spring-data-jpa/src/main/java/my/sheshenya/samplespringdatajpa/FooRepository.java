package my.sheshenya.samplespringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
        Long deleteByName(String name);
        List<Foo> deleteByEmail(String email);

        @Modifying
        @Query("delete from Foo f where f.name=:name or f.email=:email")
        void deleteByNameOrEmail(@Param("name") String name, @Param("email") String email);
        //List<Foo> removeByNameOrEmail(@Param("name") String name, @Param("email") String email);


        @Modifying
        @Query("delete from Foo f where f.name=:#{#foo.name} or f.email=:#{#foo.email}")
        void deleteByNameOrEmail(@Param("foo") Foo foo);



}