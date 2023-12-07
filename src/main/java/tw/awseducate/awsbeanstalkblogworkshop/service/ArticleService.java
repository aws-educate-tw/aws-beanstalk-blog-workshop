package tw.awseducate.awsbeanstalkblogworkshop.service;

import java.util.List;
import tw.awseducate.awsbeanstalkblogworkshop.dto.UpdateArticleRequestDto;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;

public interface ArticleService {

  Article createArticle(Article article);

  List<Article> getArticleList();

  Article updateArticle(UpdateArticleRequestDto updateArticleRequestDto);

}
