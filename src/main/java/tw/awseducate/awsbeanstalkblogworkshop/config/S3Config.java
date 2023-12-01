package tw.awseducate.awsbeanstalkblogworkshop.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

  @Value("${aws.s3.accessKey}")
  private String accessKeyId;

  @Value("${aws.s3.secretKey}")
  private String secretKey;

  @Value("${aws.region}")
  private String region;

  @Bean
  public AmazonS3 generateS3Client() {
    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretKey);
    return AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .withRegion(Regions.fromName(region))
        .build();
  }
}
