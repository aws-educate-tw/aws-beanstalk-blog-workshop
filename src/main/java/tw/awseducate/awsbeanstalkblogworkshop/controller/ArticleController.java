package tw.awseducate.awsbeanstalkblogworkshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;
import tw.awseducate.awsbeanstalkblogworkshop.service.ArticleService;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ArticleController {

  private final ArticleService articleService;

  @PostMapping("/articles")
  public ResponseEntity<Article> createArticle(Article article) {
    return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(article));
  }

  @GetMapping("/articles")
  public ResponseEntity<List<Article>> getArticleList() {

    return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleList());
  }
}
