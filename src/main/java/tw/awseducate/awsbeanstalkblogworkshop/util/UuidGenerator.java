package tw.awseducate.awsbeanstalkblogworkshop.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UuidGenerator {
  public String getUuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
