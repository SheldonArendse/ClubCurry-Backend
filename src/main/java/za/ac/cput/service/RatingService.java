package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rating;
import za.ac.cput.repository.RatingRepo;
import za.ac.cput.service.interfaces.IRatingService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class RatingService implements IRatingService {

    private RatingRepo ratingRepo;

    @Autowired
    public RatingService(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Rating save(Rating obj) {
        return ratingRepo.save(obj);
    }

    @Override
    public Rating read(Long aLong) {
        return ratingRepo.findById(aLong).orElse(null);
    }

    @Override
    public Rating update(Rating obj) {
        if(ratingRepo.existsById(obj.getId())){
            return ratingRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(ratingRepo.existsById(aLong)){
            ratingRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }
}