package my.sheshenya.samplespringdatajdbc;

import org.springframework.data.relational.core.mapping.Table;

@Table("Book_Author")
public class AuthorRef {
    public Long author;

}
