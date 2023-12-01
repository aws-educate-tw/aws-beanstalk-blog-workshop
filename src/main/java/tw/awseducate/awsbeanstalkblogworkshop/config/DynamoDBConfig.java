package tw.awseducate.awsbeanstalkblogworkshop.config;

import com.amazonaws.client.builder.AwsClientBuilder;
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

  @Bean
  public DynamoDBMapper dynamoDBMapper() {
    AmazonDynamoDBClientBuilder clientBuilder = AmazonDynamoDBClientBuilder.standard();

    if (dynamodbEndpoint != null && !dynamodbEndpoint.isEmpty()) {
      clientBuilder.withEndpointConfiguration(
          new AwsClientBuilder.EndpointConfiguration(
              dynamodbEndpoint,
              awsRegion
          )
      );
    }
    return new DynamoDBMapper(clientBuilder.build());
  }
}

