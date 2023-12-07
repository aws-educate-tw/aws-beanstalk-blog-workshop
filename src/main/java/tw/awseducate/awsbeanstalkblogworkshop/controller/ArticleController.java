package tw.awseducate.awsbeanstalkblogworkshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tw.awseducate.awsbeanstalkblogworkshop.dto.UpdateArticleRequestDto;
import tw.awseducate.awsbeanstalkblogworkshop.model.Article;
import tw.awseducate.awsbeanstalkblogworkshop.service.ArticleService;
import tw.awseducate.awsbeanstalkblogworkshop.service.S3FileUploadService;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ArticleController {

  private final ArticleService articleService;
  private final S3FileUploadService s3FileUploadService;

  @PostMapping("/articles")
  public ResponseEntity<Article> createArticle(
      @RequestParam(value = "image", required = false) List<MultipartFile> files,
      @RequestParam(value = "data") String articleJson) throws JsonProcessingException {

    // Convert data to Article object
    ObjectMapper objectMapper = new ObjectMapper();
    Article article = objectMapper.readValue(articleJson, Article.class);

    // Upload the image to S3
    List<URL> fileUrls = null;
    if (files != null) {
      s3FileUploadService.uploadFile(files);
      fileUrls = s3FileUploadService.uploadFile(files);
      article.setImageUrl(fileUrls.get(0).toString());
    }

    Article createdArticle = articleService.createArticle(article);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
  }

  @GetMapping("/articles")
  public ResponseEntity<List<Article>> getArticleList() {

    return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleList());
  }

  @GetMapping("/articles/{articleId}")
  public ResponseEntity<Article> getArticleById(@PathVariable String articleId) {

    return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleById(articleId));
  }

  @PatchMapping("/articles/{articleId}")
  public ResponseEntity<Article> updateArticle(
      @PathVariable String articleId,
      @RequestBody UpdateArticleRequestDto updateArticleRequestDto) {


    return ResponseEntity.status(HttpStatus.OK).body(articleService.updateArticle(articleId, updateArticleRequestDto));
  }
}
