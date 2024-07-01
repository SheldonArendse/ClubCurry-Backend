package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chef;
import za.ac.cput.repository.ChefRepo;
import za.ac.cput.service.interfaces.IChefService;

import java.util.List;

@Service
public class ChefService implements IChefService {

    private ChefRepo chefRepo;

    @Autowired
    public ChefService(ChefRepo chefRepo) {
        this.chefRepo = chefRepo;
    }


    @Override
    public Chef save(Chef obj) {
        return chefRepo.save(obj);
    }

    @Override
    public Chef read(String s) {
        return chefRepo.findById(s).orElse(null);
    }

    @Override
    public Chef update(Chef obj) {
        if(chefRepo.existsById(obj.getId())){
            return chefRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(chefRepo.existsById(s)){
            chefRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Chef> getAll() {
        return chefRepo.findAll();
    }
}
