package tw.awseducate.awsbeanstalkblogworkshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {

  private String articleId;
  private String title;
  private String content;
  private String poster;
}
