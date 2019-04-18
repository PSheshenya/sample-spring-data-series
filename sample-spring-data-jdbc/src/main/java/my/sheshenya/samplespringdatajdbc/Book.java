package my.sheshenya.samplespringdatajdbc;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Book {

    @CreatedBy
    String createdBy;
    @CreatedDate
    Instant createdAt;
    @LastModifiedBy
    String updatedBy;
    @LastModifiedDate
    Instant updateAt;


    @Id
    private Long id;

    private String title;

    private Set<AuthorRef> authors = new HashSet<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author)  {
        authors.add(createAuthorRef(author));

    }

    private AuthorRef createAuthorRef(Author author) {
        Assert.notNull(author, "author must be not null");
        Assert.notNull(author.getId(), "authorID must be not null");

        AuthorRef authorRef = new AuthorRef();
        authorRef.author = author.getId();

        return authorRef;
    }
}
