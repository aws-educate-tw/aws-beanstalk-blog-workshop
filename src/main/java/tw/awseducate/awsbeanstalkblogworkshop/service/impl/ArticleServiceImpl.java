package tw.awseducate.awsbeanstalkblogworkshop.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tw.awseducate.awsbeanstalkblogworkshop.dto.UpdateArticleRequestDto;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;
import tw.awseducate.awsbeanstalkblogworkshop.repository.ArticleRepository;
import tw.awseducate.awsbeanstalkblogworkshop.service.ArticleService;
import tw.awseducate.awsbeanstalkblogworkshop.util.CustomDateFormatter;
import tw.awseducate.awsbeanstalkblogworkshop.util.UuidGenerator;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  private final UuidGenerator uuidGenerator;
  private final CustomDateFormatter customDateFormatter;
  private final ModelMapper modelMapper;

  @Override
  public Article createArticle(Article article) {
    article.setArticleId(uuidGenerator.getUuid());

    // Get the current time and format it
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+8"));
    article.setCreateAt(customDateFormatter.formatZonedDateTime(now));
    article.setUpdateAt(customDateFormatter.formatZonedDateTime(now));
    articleRepository.saveArticle(article);


    return article;
  }


  @Override
  public List<Article> getArticleList() {
    return articleRepository.getArticleList();
  }

  @Override
  public Article getArticleById(String articleId) {
    return articleRepository.getArticleById(articleId);
  }

  @Override
  public Article updateArticle(String articleId, UpdateArticleRequestDto updateArticleRequestDto) {
    Article article = getArticleById(articleId);
    if (article != null) {
      modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
      modelMapper.map(updateArticleRequestDto, article);

      ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+8"));
      article.setUpdateAt(customDateFormatter.formatZonedDateTime(now));
      articleRepository.saveArticle(article);
      return article;
    }
    return null;
  }

}
