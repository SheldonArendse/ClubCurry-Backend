package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Image;
import za.ac.cput.repository.ImageRepo;
import za.ac.cput.service.interfaces.IImageService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class ImageService implements IImageService {

    private ImageRepo imageRepo;

    @Autowired
    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Override
    public Image save(Image obj) {
        return imageRepo.save(obj);
    }

    @Override
    public Image read(Long aLong) {
        return imageRepo.findById(aLong).orElse(null);
    }

    @Override
    public Image update(Image obj) {
        if(imageRepo.existsById(obj.getId())){
            return imageRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(imageRepo.existsById(aLong)){
            imageRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Image> getAll() {
        return imageRepo.findAll();
    }
}
