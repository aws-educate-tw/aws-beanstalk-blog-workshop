package tw.awseducate.awsbeanstalkblogworkshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateArticleRequestDto {

  private String title;
  private String content;
  private String poster;
  private String updateAt;
}
