package tw.awseducate.awsbeanstalkblogworkshop.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;
import tw.awseducate.awsbeanstalkblogworkshop.repository.ArticleRepository;
import tw.awseducate.awsbeanstalkblogworkshop.service.ArticleService;
import tw.awseducate.awsbeanstalkblogworkshop.util.UuidGenerator;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  private final UuidGenerator uuidGenerator;

  @Override
  public Article createArticle(Article article) {
    article.setArticleId(uuidGenerator.getUuid());
    articleRepository.createArticle(article);

    return article;
  }


  @Override
  public List<Article> getArticleList() {
    return articleRepository.getArticleList();
  }
}
