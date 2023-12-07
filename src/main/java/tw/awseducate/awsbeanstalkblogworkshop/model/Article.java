package tw.awseducate.awsbeanstalkblogworkshop.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "article")
public class Article {

  @DynamoDBHashKey(attributeName = "articleId")
  private String articleId;

  @DynamoDBAttribute(attributeName = "title")
  private String title;

  @DynamoDBAttribute(attributeName = "content")
  private String content;

  @DynamoDBAttribute(attributeName = "poster")
  private String poster;

  @DynamoDBAttribute(attributeName = "imageUrl")
  private String imageUrl;

  @DynamoDBAttribute(attributeName = "createAt")
  private String createAt;

  @DynamoDBAttribute(attributeName = "updateAt")
  private String updateAt;
}
