package my.sheshenya.samplespringdatajdbc;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class Foo {

    @Id
    private Long id;

    private Date dob;

    @NotNull
    private String name;
    private String email;
}
