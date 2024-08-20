package za.ac.cput.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;

import java.util.List;

public interface IImageService extends IService<Image, Long> {
    public Image findImageByItemId(MenuItem id);
}
