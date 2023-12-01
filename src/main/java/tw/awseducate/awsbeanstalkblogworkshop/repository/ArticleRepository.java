package tw.awseducate.awsbeanstalkblogworkshop.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;

@Repository
@AllArgsConstructor
public class ArticleRepository {

  private final DynamoDBMapper dynamoDBMapper;


  public Article createArticle(Article article) {
    dynamoDBMapper.save(article);
    return article;
  }


  public List<Article> getArticleList() {
    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
    return dynamoDBMapper.scan(Article.class, scanExpression);
  }
}
