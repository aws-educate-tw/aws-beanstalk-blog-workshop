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


  public void saveArticle(Article article) {
    dynamoDBMapper.save(article);
  }

  public Article getArticleById(String articleId) {
    return dynamoDBMapper.load(Article.class, articleId);
  }

  public List<Article> getArticleList() {
    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
    return dynamoDBMapper.scan(Article.class, scanExpression);
  }

}
