package tw.awseducate.awsbeanstalkblogworkshop.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class CustomDateFormatter {

  public String formatZonedDateTime(ZonedDateTime dateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")
        .withZone(ZoneId.of("GMT+8"))
        .withLocale(Locale.ENGLISH);
    return dateTime.format(formatter);
  }
}
