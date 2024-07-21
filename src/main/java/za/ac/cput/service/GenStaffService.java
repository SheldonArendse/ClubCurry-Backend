package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.repository.GenStaffRepo;
import za.ac.cput.service.interfaces.IChefService;

import java.util.List;

@Service
public class GenStaffService implements IChefService {

    private GenStaffRepo genStaffRepo;

    @Autowired
    public GenStaffService(GenStaffRepo genStaffRepo) {
        this.genStaffRepo = genStaffRepo;
    }


    @Override
    public GeneralStaff save(GeneralStaff obj) {
        return genStaffRepo.save(obj);
    }

    @Override
    public GeneralStaff read(String s) {
        return genStaffRepo.findById(s).orElse(null);
    }

    @Override
    public GeneralStaff update(GeneralStaff obj) {
        if(genStaffRepo.existsById(obj.getId())){
            return genStaffRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(genStaffRepo.existsById(s)){
            genStaffRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<GeneralStaff> getAll() {
        return genStaffRepo.findAll();
    }
}
