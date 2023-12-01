package tw.awseducate.awsbeanstalkblogworkshop.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

  @Value("${aws.region}")
  private String region;

  @Bean
  public AmazonS3 generateS3Client() {
    AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder.standard()
        .withRegion(Regions.fromName(region));

    return clientBuilder.build();
  }
}
