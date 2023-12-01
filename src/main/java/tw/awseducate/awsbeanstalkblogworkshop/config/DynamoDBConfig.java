package tw.awseducate.awsbeanstalkblogworkshop.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

  @Value("${aws.dynamodb.endpoint}")
  private String dynamodbEndpoint;

  @Value("${aws.region}")
  private String awsRegion;

  @Value("${aws.dynamodb.accessKey}")
  private String dynamodbAccessKey;

  @Value("${aws.dynamodb.secretKey}")
  private String dynamodbSecretKey;

  @Value("${aws.dynamodb.sessionToken}")
  private String dynamodbSessionToken;

  @Bean
  public DynamoDBMapper dynamoDBMapper() {
    return new DynamoDBMapper(buildAmazonDynamoDB());
  }

  private AmazonDynamoDB buildAmazonDynamoDB() {
    return AmazonDynamoDBClientBuilder
        .standard()
        .withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration(
                dynamodbEndpoint,
                awsRegion
            )
        )
        .withCredentials(
            new AWSStaticCredentialsProvider(
                new BasicSessionCredentials(
                    dynamodbAccessKey,
                    dynamodbSecretKey,
                    dynamodbSessionToken
                )
            )
        )
        .build();
  }
}
