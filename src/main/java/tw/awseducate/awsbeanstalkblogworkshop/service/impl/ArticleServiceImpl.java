package tw.awseducate.awsbeanstalkblogworkshop.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;
import tw.awseducate.awsbeanstalkblogworkshop.repository.ArticleRepository;
import tw.awseducate.awsbeanstalkblogworkshop.service.ArticleService;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  @Override
  public List<Article> getArticleList() {
    return articleRepository.getArticleList();
  }
}
