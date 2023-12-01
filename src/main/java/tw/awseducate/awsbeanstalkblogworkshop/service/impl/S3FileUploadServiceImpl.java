package tw.awseducate.awsbeanstalkblogworkshop.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tw.awseducate.awsbeanstalkblogworkshop.service.S3FileUploadService;
import tw.awseducate.awsbeanstalkblogworkshop.util.UuidGenerator;

@Service
public class S3FileUploadServiceImpl implements S3FileUploadService {

  private String bucketName;
  private UuidGenerator uuidGenerator;
  private AmazonS3 amazonS3Client;

  @Autowired
  public S3FileUploadServiceImpl(@Value("${aws.s3.bucketName}") String bucketName,
      UuidGenerator uuidGenerator,
      AmazonS3 amazonS3Client) {
    this.bucketName = bucketName;
    this.uuidGenerator = uuidGenerator;
    this.amazonS3Client = amazonS3Client;
  }


  @Override
  public List<URL> uploadFile(List<MultipartFile> files) {
    List<URL> urls = new ArrayList<>();
    for (MultipartFile file : files) {
      String fileUuid = uuidGenerator.getUuid();
      String keyName = fileUuid + "_" + file.getOriginalFilename();

      try {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        amazonS3Client.putObject(
            new PutObjectRequest(bucketName, keyName, file.getInputStream(), metadata));

        URL fileUrl = amazonS3Client.getUrl(bucketName, keyName);
        urls.add(fileUrl);
      } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately
        return Collections.emptyList();
      }
    }
    return urls;
  }
}
