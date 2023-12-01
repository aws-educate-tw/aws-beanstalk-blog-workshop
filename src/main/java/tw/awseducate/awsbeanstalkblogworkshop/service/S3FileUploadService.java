package tw.awseducate.awsbeanstalkblogworkshop.service;

import java.net.URL;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface S3FileUploadService {

   List<URL> uploadFile(List<MultipartFile> files);

}
