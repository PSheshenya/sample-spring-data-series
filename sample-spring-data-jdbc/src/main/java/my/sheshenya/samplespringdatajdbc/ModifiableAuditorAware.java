package my.sheshenya.samplespringdatajdbc;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class ModifiableAuditorAware implements AuditorAware<String> {

    String value;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(value);
    }
}
