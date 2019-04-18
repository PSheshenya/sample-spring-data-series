package my.sheshenya.samplespringdatajdbc;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Master {

    @Id
    private Long id;

    @NotNull
    private String name;

    private Map<String, Detail> details = new HashMap<>();
}
