package tw.awseducate.awsbeanstalkblogworkshop.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;

@Repository
@AllArgsConstructor
public class ArticleRepository {

  private final DynamoDBMapper dynamoDBMapper;

  public List<Article> getArticleList() {
    DynamoDBQueryExpression<Article> queryExpression = new DynamoDBQueryExpression<>();
    return dynamoDBMapper.query(Article.class, queryExpression);
  }
}
